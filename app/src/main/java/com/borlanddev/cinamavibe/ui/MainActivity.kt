package com.borlanddev.cinamavibe.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.borlanddev.cinamavibe.SPLASH_SCREEN_DURATION
import com.borlanddev.cinamavibe.ui.login.LoginScreen
import com.borlanddev.cinamavibe.ui.theme.CinemaVibeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private var keepSplashOnScreen = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { keepSplashOnScreen }

        setContent {
            CinemaVibeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
        lifecycleScope.launch {
            delay(SPLASH_SCREEN_DURATION)
            keepSplashOnScreen = false
        }
    }
}