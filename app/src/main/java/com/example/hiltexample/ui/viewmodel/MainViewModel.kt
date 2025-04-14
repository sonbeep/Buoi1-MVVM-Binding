package com.example.hiltexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.hiltexample.data.repository.FakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fakeRepository: FakeRepository
) : ViewModel() {
    val postPagingFlow = fakeRepository.getRandomQuote().cachedIn(viewModelScope)
}