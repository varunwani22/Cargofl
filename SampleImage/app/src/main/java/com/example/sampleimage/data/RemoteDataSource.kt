package com.example.sampleimage.data

import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun gettingImages(limit: Int, page: Int, order: String) =
        apiService.gettingImages(limit = limit, page = page, order = order)
}