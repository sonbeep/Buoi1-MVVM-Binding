package com.example.hiltexample.data.repository

import androidx.paging.PagingData
import com.example.hiltexample.data.model.Post
import kotlinx.coroutines.flow.Flow

interface FakeRepository {
    fun getPost(): Flow<PagingData<Post>>
}