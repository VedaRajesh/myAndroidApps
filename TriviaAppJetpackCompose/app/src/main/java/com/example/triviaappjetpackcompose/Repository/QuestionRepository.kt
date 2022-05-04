package com.example.triviaappjetpackcompose.Repository

import com.example.triviaappjetpackcompose.Data.DataOrException
import com.example.triviaappjetpackcompose.Model.QuestionItem
import com.example.triviaappjetpackcompose.Network.QuestionApi
import java.lang.Exception
import javax.inject.Inject


class QuestionRepository @Inject constructor(
    private val api : QuestionApi
){
    private val dataOrExceptopn = DataOrException<ArrayList<QuestionItem>,Boolean, java.lang.Exception>()

    suspend fun getAllQuestion(): DataOrException<ArrayList<QuestionItem>,Boolean, java.lang.Exception>{
        try {
            dataOrExceptopn.loading = true
            dataOrExceptopn.data = api.getAllQuestion()
            if (dataOrExceptopn.data.toString().isNotEmpty()) dataOrExceptopn.loading = false
        }catch (exception : Exception){
            dataOrExceptopn.e =exception
        }

        return dataOrExceptopn
    }

}