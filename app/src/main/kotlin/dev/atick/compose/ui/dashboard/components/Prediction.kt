package dev.atick.compose.ui.dashboard.components

import ai.atick.material.MaterialColor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forest
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Prediction(
    label: String,
    amount: String,
    icon: ImageVector,
    color: Color = MaterialTheme.colors.onSurface,
    bgColor: Color = MaterialColor.BlueGray100
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(bgColor),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Forest",
                tint = color
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = label, color = color)
        }
        Text(
            modifier = Modifier.padding(end = 16.dp),
            text = amount,
            color = color,
            fontWeight = FontWeight.Bold
        )
    }
}