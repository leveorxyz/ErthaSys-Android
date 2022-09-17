package dev.atick.network.data

import android.graphics.Bitmap

data class SegmentationResult(
    val image: Bitmap?,
    val vegetation: String = "unknown",
    val water: String = "unknown",
    val building: String = "unknown",
    val road: String = "unknown",
    val land: String = "unknown",
    val unlabeled: String = "unknown",
)
