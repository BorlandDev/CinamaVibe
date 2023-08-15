package com.borlanddev.cinamavibe.splash

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.borlanddev.cinamavibe.MainActivity
import com.borlanddev.cinamavibe.SPLASH_SCREEN_DURATION
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen().setKeepOnScreenCondition {
                splashViewModel.isScreenLoading.value
            }
        } else {
            lifecycleScope.launchWhenCreated {
                delay(SPLASH_SCREEN_DURATION)
                Intent(this@SplashActivity, MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}
