package com.example.mealzapp.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val strCategory : String,
    val strCategoryThumb : String,
    val strCategoryDescription : String,
)
