package com.example.hiltexample.domain.service

import com.example.hiltexample.data.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("posts")
    suspend fun getPost(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<Post>
}