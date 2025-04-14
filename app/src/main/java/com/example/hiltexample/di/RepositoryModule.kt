package com.example.hiltexample.di

import com.example.hiltexample.data.repository.FakeRepository
import com.example.hiltexample.data.repository.FakeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun provideRepository(fakeRepositoryImpl: FakeRepositoryImpl): FakeRepository
}