package com.ortalesoft.letsshop.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ortalesoft.letsshop.presentation.navigation.on_boarding.OnBoardingNavigation
import com.ortalesoft.letsshop.presentation.screens.loading.LoadingScreenState
import com.ortalesoft.letsshop.presentation.screens.loading.LoadingViewModel
import com.ortalesoft.letsshop.presentation.ui.theme.LetsShopTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: LoadingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition {
            val state = viewModel.meScreenState.value
            state is LoadingScreenState.Idle || state is LoadingScreenState.Loading
        }

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LetsShopTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val meState by viewModel.meScreenState.collectAsStateWithLifecycle()

                    OnBoardingNavigation(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        meState = meState
                    )
                }
            }
        }
    }
}