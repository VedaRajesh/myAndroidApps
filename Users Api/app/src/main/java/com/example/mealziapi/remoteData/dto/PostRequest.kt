package com.example.mealziapi.remoteData.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val postId : Int,
    val name : String,
    val email : String,
    val body : String
)
