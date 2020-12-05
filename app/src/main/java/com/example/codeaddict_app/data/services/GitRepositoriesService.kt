package com.example.codeaddict_app.data.services

import com.example.codeaddict_app.data.models.api.RepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitRepositoriesService {
    @GET("search/repositories")
    suspend fun getRepositories(@Query("q") query: String): RepositoriesResponse
}