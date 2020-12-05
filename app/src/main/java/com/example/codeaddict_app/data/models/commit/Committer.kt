package com.example.codeaddict_app.data.models.commit


import com.google.gson.annotations.SerializedName

data class Committer(
    val date: String,
    val name: String,
    val email: String
)