package com.example.hiltexample.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltexample.data.room.dao.PostDao
import com.example.hiltexample.data.room.entity.PostEntity

@Database(
    entities = [PostEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}