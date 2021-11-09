package com.example.mealzapp.remote

import com.example.mealzapp.remote.dto.PostRequest
import com.example.mealzapp.remote.dto.PostResponce
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*

interface PostService {

    suspend fun getPost(): List<PostResponce>

    suspend fun creatPost(postRequest: PostRequest): PostResponce?

    companion object {
        fun create(): PostServiceImp {
            return PostServiceImp(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL
                    }
                }
            )
        }
    }
}