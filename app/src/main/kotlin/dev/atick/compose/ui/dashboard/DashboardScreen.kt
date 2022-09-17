package dev.atick.compose.ui.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.atick.compose.R
import dev.atick.compose.ui.common.components.TopBar
import dev.atick.compose.ui.dashboard.components.Predictions

@Composable
fun DashboardScreen() {

    val scaffoldState = rememberScaffoldState()

    return Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(title = "Dashboard", onRefreshClick = {}, onMenuClick = {}) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Upload, contentDescription = "Upload")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .then(Modifier.padding(16.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = painterResource(id = R.drawable.satellite_image_demo),
                        contentDescription = "demo",
                        contentScale = ContentScale.FillWidth
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Predictions()
            }
        }
    )
}