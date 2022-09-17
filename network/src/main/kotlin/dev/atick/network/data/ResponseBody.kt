package dev.atick.network.data

import com.google.gson.annotations.SerializedName

data class ResponseBody(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("prediction")
    val base64Image: String?,
    @SerializedName("class_distribution")
    val classDistribution: ClassDistribution?
)
