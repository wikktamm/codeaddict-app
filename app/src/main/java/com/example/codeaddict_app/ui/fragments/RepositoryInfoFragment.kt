package com.example.codeaddict_app.ui.fragments

import android.os.Bundle
import android.view.View
import com.example.codeaddict_app.R
import kotlinx.android.synthetic.main.fragment_repository_info.*

class RepositoryInfoFragment : BaseFragment(R.layout.fragment_repository_info) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSupportActionBar(toolbar)
        setToolbarTitle()
    }

}