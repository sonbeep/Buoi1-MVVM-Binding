package com.example.hiltexample.data.repository

import com.example.hiltexample.data.model.Post
import kotlinx.coroutines.flow.Flow

interface FakeRepository {
    fun getRandomQuote(): Flow<List<Post>>
}