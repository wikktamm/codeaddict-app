package com.example.codeaddict_app.data.models.commit


import com.google.gson.annotations.SerializedName

data class Author(
    val date: String,
    val name: String,
    val email: String
)