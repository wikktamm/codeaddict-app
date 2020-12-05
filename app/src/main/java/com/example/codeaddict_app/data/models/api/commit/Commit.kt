package com.example.codeaddict_app.data.models.api.commit


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Commit(
    val author: Author,
    val committer: Committer,
    val message: String,
    val tree: Tree,
    val url: String,
    @SerializedName("comment_count")
    val commentCount: Int,
    val verification: Verification
) : Serializable