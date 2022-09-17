package dev.atick.network.repository

import android.graphics.Bitmap
import dev.atick.network.data.SegmentationResult

interface ErthaSysRepository {
    suspend fun getSegmentationResults(image: Bitmap): SegmentationResult
}