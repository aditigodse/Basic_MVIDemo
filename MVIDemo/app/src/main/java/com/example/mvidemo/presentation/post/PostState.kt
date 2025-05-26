
package com.example.mviapp.presentation.post

import com.example.assignment.ui.model.Products

data class ProductsState(
    val isLoading: Boolean = false,
    val posts: List<Products> = emptyList(),
    val error: String? = null
)
