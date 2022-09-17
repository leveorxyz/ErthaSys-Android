package dev.atick.network.data

import com.google.gson.annotations.SerializedName

data class RequestBody(
    @SerializedName("image")
    val base64Image: String
)
