package com.example.mealzapp.remote

import com.example.mealzapp.remote.dto.PostRequest
import com.example.mealzapp.remote.dto.PostResponce
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*

class PostServiceImp(
    val client: HttpClient,
) : PostService {
    override suspend fun getPost(): List<PostResponce> {
        return try {
            client.get {
                url(HttpRouts.POST)
            }
        } catch (e: RedirectResponseException) {
            println(e.response.status.description)
            emptyList()
        } catch (e: ServerResponseException) {
            println(e.response.status.description)
            emptyList()
        } catch (e: ClientRequestException) {
            println(e.response.status.description)
            emptyList()
        } catch (e: Exception) {
            println(e.message)
            emptyList()
        }
    }

    override suspend fun creatPost(postRequest: PostRequest): PostResponce? {
        return try {
            client.post {
                url(HttpRouts.POST)
                contentType(ContentType.Any)
                body = postRequest
            }
        } catch (e: RedirectResponseException) {
            println(e.response.status.description)
            null
        } catch (e: ServerResponseException) {
            println(e.response.status.description)
            null
        } catch (e: ClientRequestException) {
            println(e.response.status.description)
            null
        } catch (e: Exception) {
            println(e.message)
            null
        }
    }

}