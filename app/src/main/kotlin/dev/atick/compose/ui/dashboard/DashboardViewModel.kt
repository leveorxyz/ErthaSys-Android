package dev.atick.compose.ui.dashboard

import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.network.data.SegmentationResult
import dev.atick.network.repository.ErthaSysRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val erthaSysRepository: ErthaSysRepository
) : ViewModel() {
    var loading by mutableStateOf(false)
    val inputImage = mutableStateOf<Bitmap?>(null)
    val outputImage = mutableStateOf<Bitmap?>(null)
    val segmentationResult = mutableStateOf(SegmentationResult(null))
    val pieChartDataset = mutableStateOf(PieDataSet(listOf(), ""))

    fun segmentImage(image: Bitmap) {
        viewModelScope.launch {
            loading = true
            val result = erthaSysRepository.getSegmentationResults(image)
            result.image?.let { segmentedImage ->
                outputImage.value = segmentedImage
                segmentationResult.value = result
                pieChartDataset.value = PieDataSet(
                    listOf(
                        PieEntry(getNumericValue(result.water), "Vegetation"),
                        PieEntry(getNumericValue(result.land), "Land"),
                        PieEntry(getNumericValue(result.vegetation), "Water"),
                        PieEntry(getNumericValue(result.road), "Road"),
                        PieEntry(getNumericValue(result.building), "Building"),
                        // PieEntry(getNumericValue(result.unlabeled), ""),
                    ),
                    ""
                )
            }
            loading = false
        }
    }

    fun resetEverything() {
        inputImage.value = null
        outputImage.value = null
        segmentationResult.value = SegmentationResult(null)
        pieChartDataset.value = PieDataSet(listOf(), "")
    }

    private fun getNumericValue(percentageString: String): Float {
        return percentageString
            .slice(0 until percentageString.length - 1)
            .toFloat()
    }
}