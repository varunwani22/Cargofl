package com.example.sampleimage.repo

import com.example.sampleimage.data.RemoteDataSource
import com.example.sampleimage.models.ImageResponseModel
import com.example.sampleimage.util.BaseResponse
import com.example.sampleimage.util.NetworkResult
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import javax.inject.Inject


/*
Repository class
 */

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseResponse() {
    suspend fun gettingImages(
        limit: Int,
        page: Int,
        order: String
    ): kotlinx.coroutines.flow.Flow<NetworkResult<ImageResponseModel>> {
        return flow {
            emit(safeApiCall { remoteDataSource.gettingImages(limit, page, order) })
        }
    }

}