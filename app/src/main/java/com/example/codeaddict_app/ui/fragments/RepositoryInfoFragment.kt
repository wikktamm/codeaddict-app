package com.example.codeaddict_app.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.codeaddict_app.R
import com.example.codeaddict_app.adapters.CommitsAdapter
import com.example.codeaddict_app.data.models.api.commit.Commit
import com.example.codeaddict_app.data.models.api.commit.CommitResponse
import com.example.codeaddict_app.data.models.api.repo.Repository
import com.example.codeaddict_app.util.Constants.BUNDLE_KEY_CHOSEN_REPO
import com.example.codeaddict_app.util.empty
import com.example.codeaddict_app.viewmodels.RepositoriesInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_repository_info.*

@AndroidEntryPoint
class RepositoryInfoFragment : BaseFragment(R.layout.fragment_repository_info) {

    private lateinit var chosenRepo: Repository
    private val viewModel: RepositoriesInfoViewModel by viewModels()
    private lateinit var commitsAdapter: CommitsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getRepositoryFromBundle()
        setupRecyclerView()
        setListeners()
        observeOnChanges()
        displayUserInfo()
        getRepositoryInfo()
    }

    private fun setListeners() {
        tv_back.setOnClickListener {
            findNavController().popBackStack()
        }
        bt_view_online.setOnClickListener {
            openRepoInBrowser()
        }
        bt_share_repo.setOnClickListener {
            shareRepoInfo()
        }
    }

    private fun openRepoInBrowser() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(chosenRepo.htmlUrl)
        startActivity(intent)
    }

    private fun shareRepoInfo() {
        val info = "${chosenRepo.name} ${chosenRepo.htmlUrl}"
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(
            Intent.EXTRA_TEXT,
            info
        )
        sendIntent.type = "text/plain"
        startActivity(sendIntent)
    }

    private fun setupRecyclerView(commits: List<Commit> = emptyList()) {
        commitsAdapter = CommitsAdapter(commits)
        with(rv_commits) {
            adapter = commitsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }

    override fun onResume() {
        super.onResume()
        tv_no_commits.text = String.empty()
    }

    private fun displayUserInfo() {
        tv_author.text = chosenRepo.owner.login
        val starsCount = chosenRepo.stargazersCount
        tv_stars_count.text = resources.getString(R.string.number_of_stars, starsCount)
        val imageUrl = chosenRepo.owner.avatarUrl
        Glide.with(this).load(imageUrl).into(iv_author)
        tv_repo_title.text = chosenRepo.name
    }

    private fun getRepositoryInfo() {
        viewModel.getCommits(chosenRepo)
    }

    private fun observeOnChanges() {
        with(viewModel) {
            repoCommitInfo.observe(viewLifecycleOwner, Observer { repo ->
                synchronizeUiWithData(repo)
            })
        }
    }

    private fun synchronizeUiWithData(commitList: CommitResponse) {
        if (commitList.size > 0) {
            commitsAdapter.addItems(commitList.subList(0, 3).map { x -> x.commit })
            commitsAdapter.notifyDataSetChanged()
            tv_no_commits.text = String.empty()
        } else {
            commitsAdapter.clearItems()
            tv_no_commits.text = getString(R.string.no_commits)
        }
    }

    private fun getRepositoryFromBundle() {
        chosenRepo = arguments?.get(BUNDLE_KEY_CHOSEN_REPO) as Repository
    }

}