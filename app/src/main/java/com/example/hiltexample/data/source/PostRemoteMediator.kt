package com.example.hiltexample.data.source

import android.provider.MediaStore.Audio.Media
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.hiltexample.data.room.database.AppDatabase
import com.example.hiltexample.data.room.entity.PostEntity
import com.example.hiltexample.domain.service.APIService

@OptIn(ExperimentalPagingApi::class)
class PostRemoteMediator(
    private val api: APIService,
    private val db: AppDatabase
) : RemoteMediator<Int, PostEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PostEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> 1
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> {
                val lastItem = state.lastItemOrNull()
                if (lastItem == null) 1 else (state.pages.size + 1)
            }
        }
        return try {
            val response = api.getPost(page, state.config.pageSize)
            val userEntities = response.map { post ->
                PostEntity(post.id, post.userId, post.title, post.body)
            }
            db.withTransaction {
                if (loadType == LoadType.REFRESH) db.postDao().deleteAll()
                db.postDao().insertAll(userEntities)
            }

            MediatorResult.Success(endOfPaginationReached = response.isEmpty())
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}