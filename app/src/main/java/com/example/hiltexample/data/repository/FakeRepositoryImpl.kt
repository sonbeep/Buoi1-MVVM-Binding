package com.example.hiltexample.data.repository

import android.util.Log
import com.example.hiltexample.data.model.Post
import com.example.hiltexample.domain.service.APIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : FakeRepository {
    override fun getRandomQuote(): Flow<List<Post>> = flow {
        val response = apiService.getQuote()
        emit(response)
    }.catch { e ->
        Log.e("UserRepositoryImpl", "Error: ${e.message}")
        emit(emptyList())
    }
}