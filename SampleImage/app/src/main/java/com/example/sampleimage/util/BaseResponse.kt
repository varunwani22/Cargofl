package com.example.sampleimage.util

import retrofit2.Response
import java.lang.Exception

abstract class BaseResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body.let {
                    return NetworkResult.Success(body)
                }
            }
            return error("${response.code()} message ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): NetworkResult<T> =
        NetworkResult.Error("Api Failed $errorMessage")
}