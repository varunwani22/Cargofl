package com.example.sampleimage.models


import com.google.gson.annotations.SerializedName

data class ImageResponseModelItem(
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)