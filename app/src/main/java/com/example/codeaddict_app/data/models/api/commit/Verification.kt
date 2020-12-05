package com.example.codeaddict_app.data.models.api.commit

import java.io.Serializable

data class Verification(
    val verified: Boolean,
    val reason: String,
    val signature: Any,
    val payload: Any
)  : Serializable