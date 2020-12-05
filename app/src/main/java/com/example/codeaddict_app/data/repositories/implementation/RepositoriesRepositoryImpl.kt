package com.example.codeaddict_app.data.repositories.implementation

import com.example.codeaddict_app.data.ApiHeaderProvider
import com.example.codeaddict_app.data.models.api.commit.CommitResponse
import com.example.codeaddict_app.data.models.api.repo.RepositoriesResponse
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
            try {
                val repos = apiService.getRepositories(query)
                emit(repos)
            } catch (e: Exception) {
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getCommits(fullname: String): Flow<CommitResponse> {
        return flow {
            try {
                val commitInfo =
                    apiService.getCommits(
                        headers = ApiHeaderProvider.getAcceptHeaders(),
                        fullname = fullname
                    )
                emit(commitInfo)
            } catch (e: Exception) {
            }
        }.flowOn(Dispatchers.IO)
    }
}