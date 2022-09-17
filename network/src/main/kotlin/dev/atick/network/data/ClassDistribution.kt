package dev.atick.network.data

import com.google.gson.annotations.SerializedName

data class ClassDistribution(
    @SerializedName("Vegetation")
    val vegetation: String,
    @SerializedName("Water")
    val water: String,
    @SerializedName("Building")
    val building: String,
    @SerializedName("Road")
    val road: String,
    @SerializedName("Land")
    val land: String,
    @SerializedName("Unlabeled")
    val unlabeled: String,
)
