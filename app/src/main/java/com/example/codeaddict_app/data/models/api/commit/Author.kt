package com.example.codeaddict_app.data.models.api.commit

import java.io.Serializable


data class Author(
    val name: String,
    val email: String,
    val date: String
) : Serializable