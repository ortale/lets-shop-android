package com.ortalesoft.letsshop.presentation.navigation.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ortalesoft.letsshop.presentation.screens.signin.SignInScreen
import com.ortalesoft.letsshop.presentation.screens.signup.SignUpScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.ListsScreen.route
    ) {
        composable(AppScreens.ListsScreen.route) {
            SignInScreen(
                modifier = modifier,
                navController = navController
            )
        }
        composable(AppScreens.ProfileScreen.route) {
            SignUpScreen(
                modifier = modifier,
                navController = navController
            )
        }
    }
}