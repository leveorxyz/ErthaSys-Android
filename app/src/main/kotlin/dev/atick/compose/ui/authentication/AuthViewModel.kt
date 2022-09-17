package dev.atick.compose.ui.authentication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    val loginProgress = mutableStateOf(false)
    val name = mutableStateOf("")
    val username = mutableStateOf("")
    val password = mutableStateOf("")

    fun saveLoginCredentials() {
        viewModelScope.launch {
//            appSettings.saveLoginCredentials(
//                Login(
//                    username = username.value,
//                    password = password.value,
//                    loginStatus = true
//                )
//            )
        }
    }

    fun startLoginProcess() {
        loginProgress.value = true
    }

    fun endLoginProcess() {
        loginProgress.value = false
    }
}