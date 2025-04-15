package com.example.hiltexample.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.hiltexample.data.model.Post
import com.example.hiltexample.data.room.database.AppDatabase
import com.example.hiltexample.data.source.PostRemoteMediator
import com.example.hiltexample.domain.service.APIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class FakeRepositoryImpl @Inject constructor(
    private val apiService: APIService,
    private val appDatabase: AppDatabase
) : FakeRepository {
    override fun getPost(): Flow<PagingData<Post>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            remoteMediator = PostRemoteMediator(apiService, appDatabase),
            pagingSourceFactory = { appDatabase.postDao().getAll() }
        ).flow.map { pagingData ->
            pagingData.map { postEntity ->
                Post(postEntity.id, postEntity.userId, postEntity.title, postEntity.description)
            }

        }
    }

}