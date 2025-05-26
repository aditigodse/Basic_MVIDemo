
package com.example.mvidemo.data.repository

import com.example.assignment.ui.model.Products
import com.example.mvidemo.data.remote.ApiService
import com.example.mvidemo.domain.ProductRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: ApiService
): ProductRepository {
    override suspend fun getPosts(): List<Products> = api.getPosts()
}
