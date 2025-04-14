package com.example.hiltexample.domain.service

import com.example.hiltexample.data.model.Post
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    suspend fun getQuote(): List<Post>
}