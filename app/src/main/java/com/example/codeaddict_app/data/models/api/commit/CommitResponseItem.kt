package com.example.codeaddict_app.data.models.api.commit


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CommitResponseItem(
    val sha: String,
    @SerializedName("node_id")
    val nodeId: String,
    val commit: Commit,
    val url: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("comments_url")
    val commentsUrl: String,
    val author: AuthorX,
    val committer: CommitterX,
    val parents: List<Parent>
) : Serializable