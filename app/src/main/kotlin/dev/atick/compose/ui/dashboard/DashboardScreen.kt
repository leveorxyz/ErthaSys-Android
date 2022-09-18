package dev.atick.compose.ui.dashboard

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.atick.compose.R
import dev.atick.compose.ui.common.components.TopBar
import dev.atick.compose.ui.dashboard.components.PieChart
import dev.atick.compose.ui.dashboard.components.Predictions

@Suppress("DEPRECATION")
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var inputImage by viewModel.inputImage
    val outputImage by viewModel.outputImage
    val segmentationResult by viewModel.segmentationResult
    val pieChartDataset by viewModel.pieChartDataset
    val context = LocalContext.current

    val scaffoldState = rememberScaffoldState()
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        uri?.let {
            val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                ImageDecoder.decodeBitmap(source)
            } else {
                MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            }

            bitmap?.let { image ->
                inputImage = Bitmap.createScaledBitmap(
                    image, 512, 512, false
                )
                viewModel.segmentImage(image)
            }
        }
    }

    return Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                title = "Dashboard",
                onRefreshClick = { viewModel.resetEverything() },
                onMenuClick = {})
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                launcher.launch(arrayOf("image/*"))
                viewModel.resetEverything()
            }
            ) {
                Icon(imageVector = Icons.Filled.Upload, contentDescription = "Upload")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .then(Modifier.padding(16.dp))
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AnimatedVisibility(visible = inputImage == null) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(id = R.drawable.upload), contentDescription = "Upload")
                        Text(text = "Please Select an Image from the Gallery by Clicking the Button Below")
                    }
                }
                AnimatedVisibility(
                    modifier = Modifier.fillMaxWidth(),
                    visible = inputImage != null
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        inputImage?.let {
                            Image(
                                modifier = Modifier.fillMaxWidth(),
                                bitmap = it.asImageBitmap(),
                                contentDescription = "input",
                                contentScale = ContentScale.FillWidth
                            )
                        }
                        outputImage?.let {
                            Image(
                                modifier = Modifier.fillMaxWidth(),
                                bitmap = it.asImageBitmap(),
                                contentDescription = "input",
                                contentScale = ContentScale.FillWidth,
                                alpha = 0.3F
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                AnimatedVisibility(visible = outputImage != null) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Analysis Results", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        PieChart(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp),
                            dataset = pieChartDataset
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Predictions(segmentationResult = segmentationResult)
                    }
                }

                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    )
}