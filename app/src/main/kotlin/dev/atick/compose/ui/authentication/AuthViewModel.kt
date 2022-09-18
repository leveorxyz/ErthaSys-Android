package dev.atick.compose.ui.authentication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.atick.core.utils.Event
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    var loading by mutableStateOf(false)
    val name = mutableStateOf("")
    val username = mutableStateOf("")
    val password = mutableStateOf("")

    private val _loggedIn = MutableLiveData(Event(false))
    val loggedIn: LiveData<Event<Boolean>>
        get() = _loggedIn


    fun login() {
        viewModelScope.launch {
            loading = true
            delay(3000L)
            _loggedIn.postValue(Event(true))
            loading = false
        }
    }
}