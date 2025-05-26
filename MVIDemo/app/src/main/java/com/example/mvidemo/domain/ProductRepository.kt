package com.example.mvidemo.domain

import com.example.assignment.ui.model.Products

interface ProductRepository {
    suspend fun getPosts(): List<Products>
}