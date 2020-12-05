package com.example.codeaddict_app.data.models.commit


import com.google.gson.annotations.SerializedName

data class Item(
    val url: String,
    val sha: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("comments_url")
    val commentsUrl: String,
    val commit: Commit,
    val author: AuthorX,
    val committer: CommitterX,
    val parents: List<Parent>,
    val repository: Repository,
    val score: Double
)