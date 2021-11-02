package com.example.mealziapi.remoteData

import com.example.mealziapi.remoteData.dto.PostRequest
import com.example.mealziapi.remoteData.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class PostServiceImp(
    val client: HttpClient,
) : PostService {
    override suspend fun getPost(): List<PostResponse> {
        return try {
            client.get {
                url(HttpRouts.POST)
            }
        } catch (e: RedirectResponseException) {
            println("ERROR MESSAGE ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            print("ERROR MESSAGE ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            println("ERROR MESSAGE ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("ERROR MESSAGE ${e.message}")
            emptyList()
        }
    }

    override suspend fun creatPost(postRequest: PostRequest): PostResponse? {
        return try {
            client.post<PostResponse> {
                url(HttpRouts.POST)
                contentType(ContentType.Any)
                body = postRequest
            }
        } catch (e: RedirectResponseException) {
            println("ERROR MESSAGE ${e.response.status.description}")
            null
        } catch (e: ServerResponseException) {
            print("ERROR MESSAGE ${e.response.status.description}")
            null
        } catch (e: ClientRequestException) {
            println("ERROR MESSAGE ${e.response.status.description}")
            null
        } catch (e: Exception) {
            println("ERROR MESSAGE ${e.message}")
            null
        }
    }
}