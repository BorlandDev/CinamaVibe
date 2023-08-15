package com.borlanddev.cinamavibe.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borlanddev.cinamavibe.SPLASH_SCREEN_DURATION
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _isScreenLoading = MutableStateFlow(true)
    val isScreenLoading = _isScreenLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(SPLASH_SCREEN_DURATION)
            _isScreenLoading.value = false
        }
    }
}