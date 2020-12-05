package com.example.codeaddict_app.data.services

import com.example.codeaddict_app.data.models.api.repo.RepositoriesResponse
import com.example.codeaddict_app.data.models.commit.CommitResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GitRepositoriesService {
    @GET("search/repositories")
    suspend fun getRepositories(@Query("q") query: String): RepositoriesResponse

    @GET("search/commits")
    suspend fun getCommits(
        @Query("q") query: String,
        @Query("sort") sort: String = "committer-date",
        @Header("Accept") acceptHeader: String = "application/vnd.github.cloak-preview+json"
    ): CommitResponse
}