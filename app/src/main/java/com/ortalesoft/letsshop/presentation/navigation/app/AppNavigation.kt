package com.ortalesoft.letsshop.presentation.navigation.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ortalesoft.letsshop.presentation.screens.dashboard.profile.ProfileScreen
import com.ortalesoft.letsshop.presentation.screens.dashboard.shopping_lists.ShoppingListsScreen

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
            ShoppingListsScreen(
                modifier = modifier
            )
        }
        composable(AppScreens.ProfileScreen.route) {
            ProfileScreen(
                modifier = modifier
            )
        }
    }
}