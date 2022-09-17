package dev.atick.compose.ui.dashboard

import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.network.data.SegmentationResult
import dev.atick.network.repository.ErthaSysRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val erthaSysRepository: ErthaSysRepository
) : ViewModel() {
    val inputImage = mutableStateOf<Bitmap?>(null)
    val outputImage = mutableStateOf<Bitmap?>(null)
    val segmentationResult = mutableStateOf(SegmentationResult(null))
    val loading = mutableStateOf("")

    fun segmentImage(image: Bitmap) {
        viewModelScope.launch {
            loading.value = "Please Wait ... "
            val result = erthaSysRepository.getSegmentationResults(image)
            result.image?.let { segmentedImage ->
                outputImage.value = segmentedImage
                segmentationResult.value = result
            }
            loading.value = ""
        }
    }

    fun resetEverything() {
        inputImage.value = null
        outputImage.value = null
        segmentationResult.value = SegmentationResult(null)
    }
}