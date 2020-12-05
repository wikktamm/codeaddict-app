package com.example.codeaddict_app.data.models.api.repo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepositoriesResponse(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val repositories: List<Repository>
) : Serializable