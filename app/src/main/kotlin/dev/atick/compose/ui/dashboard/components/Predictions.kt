package dev.atick.compose.ui.dashboard.components

import ai.atick.material.MaterialColor
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.atick.network.data.SegmentationResult

@Composable
fun Predictions(segmentationResult: SegmentationResult) {
    return Column(Modifier.fillMaxWidth()) {
        Prediction(
            label = "Vegetation",
            amount = segmentationResult.vegetation,
            icon=Icons.Filled.Forest,
            color = MaterialColor.Green900,
            bgColor = MaterialColor.Green100
        )
        Spacer(modifier = Modifier.height(8.dp))
        Prediction(
            label = "Water",
            amount = "5.89%",
            icon=Icons.Filled.Water,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Prediction(
            label = "Land",
            amount = segmentationResult.land,
            icon=Icons.Filled.Texture,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Prediction(
            label = "Road",
            amount = segmentationResult.road,
            icon=Icons.Filled.AddRoad,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Prediction(
            label = "Building",
            amount = segmentationResult.building,
            icon=Icons.Filled.Domain,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Prediction(
            label = "Unlabeled",
            amount = segmentationResult.unlabeled,
            icon=Icons.Filled.Circle,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}