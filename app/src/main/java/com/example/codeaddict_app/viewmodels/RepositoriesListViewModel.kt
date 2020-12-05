package com.example.codeaddict_app.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.codeaddict_app.data.models.api.repo.RepositoriesResponse
import com.example.codeaddict_app.data.repositories.interfaces.RepositoriesRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoriesListViewModel @ViewModelInject constructor(private val repo: RepositoriesRepository) :
    BaseViewModel() {

    private val _repos = MutableLiveData<RepositoriesResponse>()
    val repos: LiveData<RepositoriesResponse>
        get() = _repos

    fun getRepositories(query: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            repo.getRepositories(query)
                .collect { result ->
                    _repos.postValue(result)
                }
            _isLoading.postValue(false)
        }
    }
}