package com.example.codeaddict_app.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.codeaddict_app.R
import com.example.codeaddict_app.viewmodels.RepositoriesListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_repositories_list.*
import javax.inject.Inject

@AndroidEntryPoint
class RepositoriesListFragment : Fragment(R.layout.fragment_repositories_list) {

    private val viewModel: RepositoriesListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_search.setOnClickListener {
            findNavController().navigate(R.id.action_repositoriesListFragment_to_repositoryInfoFragment)
        }
        tv_repos.setOnClickListener {
            viewModel.getRepositories("car")
        }
    }
}
