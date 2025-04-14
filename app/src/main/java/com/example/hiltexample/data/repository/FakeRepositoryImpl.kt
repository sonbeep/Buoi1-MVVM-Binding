package com.example.hiltexample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.hiltexample.data.model.Post
import com.example.hiltexample.data.source.PostPagingSource
import com.example.hiltexample.domain.service.APIService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FakeRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : FakeRepository {
    override fun getRandomQuote(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PostPagingSource(apiService) }
        ).flow
    }

}