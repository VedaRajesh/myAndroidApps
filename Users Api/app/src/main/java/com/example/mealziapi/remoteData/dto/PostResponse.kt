package com.example.mealziapi.remoteData.dto

import ch.qos.logback.core.joran.event.BodyEvent
import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val postId : Int,
    val id : Int, // generated
    val name : String,
    val email : String,
    val body : String
)