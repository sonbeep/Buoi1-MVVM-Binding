package com.example.hiltexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltexample.data.model.Quote
import com.example.hiltexample.data.repository.FakeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val fakeRepository: FakeRepository
) : ViewModel() {
    private val _quote = MutableStateFlow<Quote?>(null)
    val quote = _quote.asStateFlow()

    fun loadQuote() {
        viewModelScope.launch {
            fakeRepository.getRandomQuote().collect {
                _quote.value = it
            }
        }
    }
}