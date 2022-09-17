package dev.atick.network.repository

import android.graphics.Bitmap
import com.orhanobut.logger.Logger
import dev.atick.network.api.ErthaSysApi
import dev.atick.network.data.RequestBody
import dev.atick.network.data.SegmentationResult
import dev.atick.network.utils.extensions.toBase64
import dev.atick.network.utils.extensions.toBitmap
import javax.inject.Inject

class ErthaSysRepositoryImpl @Inject constructor(
    private val erthaSysApi: ErthaSysApi
) : ErthaSysRepository {
    override suspend fun getSegmentationResults(image: Bitmap): SegmentationResult {
        val base64Image = image.toBase64()

        val response = erthaSysApi.getSegmentationResults(
            RequestBody(base64Image = base64Image)
        )

        Logger.w(response.toString())

        return SegmentationResult(
            image = response.base64Image?.toBitmap(),
            vegetation = response.classDistribution?.vegetation,
            water = response.classDistribution?.water,
            road = response.classDistribution?.road,
            building = response.classDistribution?.building,
            land = response.classDistribution?.land,
            unlabeled = response.classDistribution?.unlabeled,
        )
    }
}