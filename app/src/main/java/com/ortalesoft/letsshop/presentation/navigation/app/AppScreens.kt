package com.ortalesoft.letsshop.presentation.navigation.app

sealed class AppScreens(val route: String) {
    object ListsScreen : AppScreens("lists")
    object ProfileScreen : AppScreens("profile")
}