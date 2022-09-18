package dev.atick.compose.ui.dashboard.components

import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.utils.Utils

@Composable
fun PieChart(
    dataset: PieDataSet,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        factory = { ctx ->
            Utils.init(ctx)
            com.github.mikephil.charting.charts.PieChart(ctx).apply {
                description.text = ""
                legend.textSize = 14F
                legend.isWordWrapEnabled = true
                legend.isEnabled = true
                setTouchEnabled(false)
                holeRadius = 40F
            }
        },
        update = { pieChart ->
            dataset.apply {
                colors = listOf(
                    Color.parseColor("#E2A929"),
                    Color.parseColor("#8429F6"),
                    Color.parseColor("#FEDD3A"),
                    Color.parseColor("#6EC1E4"),
                    Color.parseColor("#3C1098"),
                    // Color.parseColor("#9B9B9B")
                )
                setValueTextColors(
                    listOf(
                        Color.DKGRAY,
                        Color.WHITE,
                        Color.DKGRAY,
                        Color.WHITE,
                        Color.WHITE,
                        // Color.DKGRAY,
                    )
                )
                valueTextSize = 14F
            }
            val lineData = PieData(dataset)
            lineData.notifyDataChanged()
            pieChart.data = lineData
            pieChart.invalidate()
        },
        modifier = modifier
    )
}