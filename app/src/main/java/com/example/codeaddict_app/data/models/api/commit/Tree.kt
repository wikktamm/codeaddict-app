package com.example.codeaddict_app.data.models.api.commit

import java.io.Serializable

data class Tree(
    val sha: String,
    val url: String
) : Serializable