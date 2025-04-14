package com.example.hiltexample.data.room.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltexample.data.room.entity.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM post")
    fun getAll(): PagingSource<Int, PostEntity>

    @Query("SELECT * FROM post WHERE id = :id")
    suspend fun getById(id: Int): PostEntity

    @Query("DELETE FROM post")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<PostEntity>)
}