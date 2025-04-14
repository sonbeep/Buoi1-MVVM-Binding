package com.example.hiltexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltexample.data.model.Post
import com.example.hiltexample.data.repository.FakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fakeRepository: FakeRepository
) : ViewModel() {
    private val _post = MutableStateFlow<Post?>(null)
    val quote = _post.asStateFlow()

    fun loadQuote() {
        viewModelScope.launch {
            fakeRepository.getRandomQuote().collect {
                _post.value = it[0]
            }
        }
    }
}