package com.example.codeaddict_app.data.models.commit


import com.google.gson.annotations.SerializedName

data class CommitResponse(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<Item>
)