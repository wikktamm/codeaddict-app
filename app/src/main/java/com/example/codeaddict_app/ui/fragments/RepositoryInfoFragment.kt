package com.example.codeaddict_app.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.codeaddict_app.R
import com.example.codeaddict_app.data.models.api.repo.Repository
import com.example.codeaddict_app.data.models.commit.CommitResponse
import com.example.codeaddict_app.util.Constants.BUNDLE_KEY_CHOSEN_REPO
import com.example.codeaddict_app.viewmodels.RepositoriesInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_repository_info.*

@AndroidEntryPoint
class RepositoryInfoFragment : BaseFragment(R.layout.fragment_repository_info) {

    private lateinit var chosenRepo: Repository
    private val viewModel: RepositoriesInfoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getRepositoryFromBundle()
        observeOnChanges()
        displayUserInfo()
        getRepositoryInfo()
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
                Toast.makeText(requireActivity(), "a", Toast.LENGTH_SHORT).show()
                synchronizeUiWithData(repo)
            })
        }
    }

    private fun synchronizeUiWithData(repo: CommitResponse) {
        if (repo.items.isNotEmpty()) {
//            tv_author.text = repo.items[0].
        }
    }

    private fun getRepositoryFromBundle() {
        chosenRepo = arguments?.get(BUNDLE_KEY_CHOSEN_REPO) as Repository
    }

}