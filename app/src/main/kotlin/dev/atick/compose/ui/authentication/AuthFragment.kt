package dev.atick.compose.ui.authentication

import androidx.compose.runtime.Composable
import dev.atick.core.ui.BaseComposeFragment

class AuthFragment : BaseComposeFragment() {

    @Composable
    override fun ComposeUi() {
        AuthScreen(::login)
    }

    private fun login() {

    }
}