package com.example.codeaddict_app.ui.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_repository_info.*

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    protected fun setSupportActionBar(toolbar: Toolbar) {
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
    }

    protected fun setToolbarTitle(title: String? = null) {
        (activity as AppCompatActivity?)!!.title = title ?: ""
    }
}
