package com.example.codeaddict_app.data.repositories.implementation

import com.example.codeaddict_app.data.models.api.repo.RepositoriesResponse
import com.example.codeaddict_app.data.models.commit.CommitResponse
import com.example.codeaddict_app.data.repositories.interfaces.RepositoriesRepository
import com.example.codeaddict_app.data.services.GitRepositoriesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoriesRepositoryImpl @Inject constructor(private val apiService: GitRepositoriesService) :
    RepositoriesRepository {

    override suspend fun getRepositories(query: String): Flow<RepositoriesResponse> {
        return flow {
            val repos = apiService.getRepositories(query)
            emit(repos)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getCommits(query: String): Flow<CommitResponse> {
        return flow {
            val commitInfo = apiService.getCommits(query)
            emit(commitInfo)
        }.flowOn(Dispatchers.IO)
    }
}