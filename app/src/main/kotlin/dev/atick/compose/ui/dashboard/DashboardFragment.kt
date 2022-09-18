package dev.atick.compose.ui.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.atick.compose.ui.common.components.LoadingAnimation
import dev.atick.core.ui.BaseComposeFragment
import dev.atick.core.utils.extensions.observeEvent
import dev.atick.core.utils.extensions.showToast

@AndroidEntryPoint
class DashboardFragment : BaseComposeFragment() {

    private val viewModel: DashboardViewModel by viewModels()

    @Composable
    override fun ComposeUi() {
        Box(contentAlignment = Alignment.Center) {
            DashboardScreen(
                modifier = Modifier.alpha(
                    if (viewModel.loading) 0.2F else 1.0F
                )
            )
            AnimatedVisibility(visible = viewModel.loading) {
                LoadingAnimation()
            }
        }
    }

    override fun observeStates() {
        super.observeStates()
        observeEvent(viewModel.toast) {
            requireContext().showToast(it)
        }
    }
}