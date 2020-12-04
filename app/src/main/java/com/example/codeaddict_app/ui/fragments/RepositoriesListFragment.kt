package com.example.codeaddict_app.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codeaddict_app.R
import kotlinx.android.synthetic.main.fragment_repositories_list.*

class RepositoriesListFragment : Fragment(R.layout.fragment_repositories_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_search.setOnClickListener {
            findNavController().navigate(R.id.action_repositoriesListFragment_to_repositoryInfoFragment)
        }
    }
}
