package com.example.codeaddict_app.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codeaddict_app.data.models.api.RepositoriesResponse
import com.example.codeaddict_app.data.repositories.interfaces.RepositoriesRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class RepositoriesListViewModel @ViewModelInject constructor(private val repo: RepositoriesRepository) :
    ViewModel() {

    private val _repos = MutableLiveData<RepositoriesResponse>()
    val repos: LiveData<RepositoriesResponse>
        get() = _repos

    fun getRepositories(query: String) {
        viewModelScope.launch {
            repo.getRepositories(query)
                .collect { result ->
                    _repos.postValue(result)
                    Timber.d("123" + result.toString())
                }
        }
    }
}