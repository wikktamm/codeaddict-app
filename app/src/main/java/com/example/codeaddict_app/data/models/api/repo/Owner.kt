package com.example.codeaddict_app.data.models.api.repo
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Owner(
    val login: String,
    val id: Int,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("gravatar_id")
    val gravatarId: String,
    val url: String,
    @SerializedName("received_events_url")
    val receivedEventsUrl: String,
    val type: String
)  : Serializable