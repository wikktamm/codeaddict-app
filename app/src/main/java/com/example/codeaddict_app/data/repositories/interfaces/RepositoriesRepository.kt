package com.example.codeaddict_app.data.repositories.interfaces

import com.example.codeaddict_app.data.models.api.commit.CommitResponse
import com.example.codeaddict_app.data.models.api.repo.RepositoriesResponse
import kotlinx.coroutines.flow.Flow

interface RepositoriesRepository {
    suspend fun getRepositories(query: String): Flow<RepositoriesResponse>
    suspend fun getCommits(query: String): Flow<CommitResponse>
}