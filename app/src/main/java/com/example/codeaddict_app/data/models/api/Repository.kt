package com.example.codeaddict_app.data.models.api
import com.google.gson.annotations.SerializedName

data class Repository(
    val id: Int,
    @SerializedName("node_id")
    val nodeId: String,
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    val owner: Owner,
    val `private`: Boolean,
    @SerializedName("html_url")
    val htmlUrl: String,
    val description: String,
    val fork: Boolean,
    val url: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("pushed_at")
    val pushedAt: String,
    val homepage: String,
    val size: Int,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("watchers_count")
    val watchersCount: Int,
    val language: String,
    @SerializedName("forks_count")
    val forksCount: Int,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int,
    @SerializedName("master_branch")
    val masterBranch: String,
    @SerializedName("default_branch")
    val defaultBranch: String,
    val score: Double
)