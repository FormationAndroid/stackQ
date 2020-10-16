package com.example.stackapp

import com.example.stackapp.models.LastQuestions
import retrofit2.Call
import retrofit2.http.GET

interface StackService {

    @GET("questions?order=desc&sort=activity&site=stackoverflow")
    fun getLastQuestions() : Call<LastQuestions>

}