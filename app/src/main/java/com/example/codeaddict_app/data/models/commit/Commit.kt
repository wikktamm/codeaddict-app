package com.example.codeaddict_app.data.models.commit


import com.google.gson.annotations.SerializedName

data class Commit(
    val url: String,
    val author: Author,
    val committer: Committer,
    val message: String,
    val tree: Tree,
    @SerializedName("comment_count")
    val commentCount: Int
)