package com.example.mealziapi.remoteData

import com.example.mealziapi.remoteData.dto.PostRequest
import com.example.mealziapi.remoteData.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface PostService {
    suspend fun getPost(): List<PostResponse>

    suspend fun creatPost(postRequest: PostRequest): PostResponse?


    companion object {
        fun creat():PostServiceImp{
            return PostServiceImp(
                client = HttpClient(Android){
                    install(Logging){
                        level =LogLevel.ALL
                    }
                    install(JsonFeature){
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}