package com.example.sampleimage.data

import com.example.sampleimage.models.ImageResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v1/images/search")
    suspend fun gettingImages(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<ImageResponseModel>
}