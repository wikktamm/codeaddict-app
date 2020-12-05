package com.example.codeaddict_app.data.models.api.commit


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Parent(
    val sha: String,
    val url: String,
    @SerializedName("html_url")
    val htmlUrl: String
) : Serializable