package dev.atick.network.data

import android.graphics.Bitmap

data class SegmentationResult(
    val image: Bitmap?,
    val vegetation: String?,
    val water: String?,
    val building: String?,
    val road: String?,
    val land: String?,
    val unlabeled: String?,
)
