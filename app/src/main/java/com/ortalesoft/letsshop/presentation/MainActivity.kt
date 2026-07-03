package com.ortalesoft.letsshop.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.ortalesoft.letsshop.presentation.ui.theme.LetsShopTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var isReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition {
            !isReady
        }

        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            delay(1500)
            isReady = true
        }

        enableEdgeToEdge()
        setContent {
            LetsShopTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation(
                        modifier = Modifier.fillMaxSize().padding(16.dp)
                    )
                }
            }
        }
    }
}