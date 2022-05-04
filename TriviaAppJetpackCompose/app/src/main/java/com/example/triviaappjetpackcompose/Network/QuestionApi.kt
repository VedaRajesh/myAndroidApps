package com.example.triviaappjetpackcompose.Network

import com.example.triviaappjetpackcompose.Model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi{

    @GET("world.json")
    suspend fun getAllQuestion():Question
}