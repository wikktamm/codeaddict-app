package com.example.codeaddict_app.data.repositories.implementation

import com.example.codeaddict_app.data.models.api.repo.RepositoriesResponse
import com.example.codeaddict_app.data.repositories.interfaces.RepositoriesRepository
import com.example.codeaddict_app.data.services.GitRepositoriesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryRepositoryImpl @Inject constructor(private val apiService: GitRepositoriesService) :
    RepositoriesRepository {

    override suspend fun getRepositories(query: String): Flow<RepositoriesResponse> {
        return flow {
            val fooList = apiService.getRepositories(query)
            emit(fooList)
        }.flowOn(Dispatchers.IO)
    }
}