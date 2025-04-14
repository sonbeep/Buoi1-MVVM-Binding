package com.example.hiltexample.data.repository

import com.example.hiltexample.data.model.Quote
import kotlinx.coroutines.flow.Flow

interface FakeRepository {
    fun getRandomQuote(): Flow<Quote>
}