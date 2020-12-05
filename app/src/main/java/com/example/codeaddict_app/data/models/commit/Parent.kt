package com.example.codeaddict_app.data.models.commit


import com.google.gson.annotations.SerializedName

data class Parent(
    val url: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    val sha: String
)