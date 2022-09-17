package dev.atick.network.api

import dev.atick.network.data.RequestBody
import dev.atick.network.data.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface ErthaSysApi {
    @POST("/erthasys")
    suspend fun getSegmentationResults(@Body requestBody: RequestBody): ResponseBody

    companion object {
        const val BASE_URL = "http://192.168.1.102:5000/"
    }
}