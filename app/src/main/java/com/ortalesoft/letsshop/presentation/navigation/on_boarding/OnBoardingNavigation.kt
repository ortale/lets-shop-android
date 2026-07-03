package com.ortalesoft.letsshop.presentation.navigation.on_boarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ortalesoft.letsshop.presentation.screens.dashboard.DashboardScreen
import com.ortalesoft.letsshop.presentation.screens.loading.LoadingScreenState
import com.ortalesoft.letsshop.presentation.screens.signin.SignInScreen
import com.ortalesoft.letsshop.presentation.screens.signup.SignUpScreen

@Composable
fun OnBoardingNavigation(
    modifier: Modifier = Modifier,
    meState: LoadingScreenState
) {
    val navController = rememberNavController()

    LaunchedEffect(meState) {
        when (meState) {
            is LoadingScreenState.Success -> {
                navController.navigate(OnBoardingScreens.DashboardScreen.route) {
                    popUpTo(OnBoardingScreens.DashboardScreen.route) { inclusive = true }
                }
            }
            is LoadingScreenState.Error -> {
                navController.navigate(OnBoardingScreens.SignInScreen.route) {
                    popUpTo(OnBoardingScreens.SignInScreen.route) { inclusive = true }
                }
            }
            else -> Unit
        }
    }

    NavHost(
        navController = navController,
        startDestination = OnBoardingScreens.SignInScreen.route
    ) {
        composable(OnBoardingScreens.SignInScreen.route) {
            SignInScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable(OnBoardingScreens.SignUpScreen.route) {
            SignUpScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable(OnBoardingScreens.DashboardScreen.route) {
            DashboardScreen(
                modifier = modifier,
                navController = navController
            )
        }
    }
}