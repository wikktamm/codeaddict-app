package com.example.codeaddict_app.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.codeaddict_app.data.models.api.commit.CommitResponse
import com.example.codeaddict_app.data.models.api.repo.Repository
import com.example.codeaddict_app.data.repositories.interfaces.RepositoriesRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RepositoriesInfoViewModel @ViewModelInject constructor(private val repo: RepositoriesRepository) :
    BaseViewModel() {

    private val _repoCommitInfo = MutableLiveData<CommitResponse>()
    val repoCommitInfo: LiveData<CommitResponse>
        get() = _repoCommitInfo

    fun getCommits(chosenRepo: Repository) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            repo.getCommits(chosenRepo.fullName)
                .collect { result ->
                    _repoCommitInfo.postValue(result)
                }
            _isLoading.postValue(false)
        }
    }
}