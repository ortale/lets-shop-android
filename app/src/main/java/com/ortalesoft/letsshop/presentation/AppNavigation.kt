package com.ortalesoft.letsshop.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ortalesoft.letsshop.presentation.signin.SignInScreen
import com.ortalesoft.letsshop.presentation.signup.SignUpScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavScreens.SignInScreen.route
    ) {
        composable(NavScreens.SignInScreen.route) {
            SignInScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable(NavScreens.SignUpScreen.route) {
            SignUpScreen(
                modifier = modifier,
                navController = navController
            )
        }
    }
}