package com.example.codeaddict_app.data.services

import com.example.codeaddict_app.data.ApiHeaderProvider
import com.example.codeaddict_app.data.models.api.commit.CommitResponse
import com.example.codeaddict_app.data.models.api.repo.RepositoriesResponse
import retrofit2.http.*

interface GitRepositoriesService {

    @GET("search/repositories")
    suspend fun getRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String = "stars"
    ): RepositoriesResponse

    @GET("repos/{fullname}/commits")
    suspend fun getCommits(
        @HeaderMap headers: ApiHeaderProvider.AcceptHeaders,
        @Path("fullname", encoded = true) fullname: String
    ): CommitResponse
}