package com.example.mviapp.presentation.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvidemo.data.repository.PostRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepositoryImpl
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsState())
    val state: StateFlow<ProductsState> = _state

    fun onIntent(intent: PostIntent) {
        when (intent) {
            is PostIntent.LoadPosts -> loadPosts()
            else -> {}
        }
    }

    private fun loadPosts() {
        viewModelScope.launch {
            _state.value = ProductsState(isLoading = true)
            try {
                val posts = repository.getPosts()
                _state.value = ProductsState(posts = posts, isLoading = false)
            } catch (e: Exception) {
                _state.value = ProductsState(error = e.localizedMessage)
            }
        }
    }
}
