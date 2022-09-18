package dev.atick.network.data

import android.graphics.Bitmap

data class SegmentationResult(
    val image: Bitmap?,
    val vegetation: String = "0.0%",
    val water: String = "0.0%",
    val building: String = "0.0%",
    val road: String = "0.0%",
    val land: String = "0.0%",
    val unlabeled: String = "0.0%",
)
