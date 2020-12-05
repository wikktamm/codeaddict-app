package com.example.codeaddict_app.data.models.api

import com.google.gson.annotations.SerializedName

data class RepositoriesResponse(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val repositories: List<Repository>
)