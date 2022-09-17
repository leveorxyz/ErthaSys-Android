package dev.atick.compose.ui.dashboard

import android.provider.MediaStore
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import dev.atick.core.ui.BaseComposeFragment

@AndroidEntryPoint
class DashboardFragment : BaseComposeFragment() {

    @Composable
    override fun ComposeUi() {
        DashboardScreen()
    }
}