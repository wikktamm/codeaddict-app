package com.example.codeaddict_app.ui.fragments

import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codeaddict_app.R
import com.example.codeaddict_app.adapters.RepositoryAdapter
import com.example.codeaddict_app.util.Constants.BUNDLE_KEY_CHOSEN_REPO
import com.example.codeaddict_app.util.Constants.DELAY_TIME_AFTER_EACH_INPUT_LETTER
import com.example.codeaddict_app.util.empty
import com.example.codeaddict_app.viewmodels.RepositoriesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_repositories_list.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RepositoriesListFragment : BaseFragment(R.layout.fragment_repositories_list) {

    private val viewModel: RepositoriesListViewModel by viewModels()
    private lateinit var repositoriesAdapter: RepositoryAdapter

    override fun onResume() {
        super.onResume()
        setupRecyclerView()
        observeOnChanges()
        setListeners()

        tv_search.setOnClickListener {
            findNavController().navigate(R.id.action_repositoriesListFragment_to_repositoryInfoFragment)
        }
    }

    private fun setListeners() {
        var job: Job? = null
        et_search_query.addTextChangedListener {
            job?.cancel()
            job = MainScope().launch {
                delay(DELAY_TIME_AFTER_EACH_INPUT_LETTER)
                it?.let {
                    if (it.trim().isNotEmpty()) {
                        viewModel.getRepositories(it.trim().toString())
                    }
                }
            }
        }
    }

    private fun observeOnChanges() {
        with(viewModel) {
            repos.observe(viewLifecycleOwner, Observer { response ->
                if (response.repositories.isNotEmpty()) {
                    repositoriesAdapter.differ.submitList(response.repositories)
                    tv_no_repos.text = String.empty()
                } else {
                    tv_no_repos.text = getString(R.string.no_repos)
                }
            })
            isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
                manageProgressBar(isLoading)
            })
        }
    }

    private fun setupRecyclerView() {
        repositoriesAdapter = RepositoryAdapter()
        with(rv_repos) {
            adapter = repositoriesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        repositoriesAdapter.setOnRepoClickListener { repo ->
            val bundle = bundleOf(BUNDLE_KEY_CHOSEN_REPO to repo)
            findNavController().navigate(
                R.id.action_repositoriesListFragment_to_repositoryInfoFragment,
                bundle
            )
        }
    }
}
