package com.ortalesoft.letsshop.presentation

sealed class NavScreens(val route: String) {
    object SignInScreen : NavScreens("sign_in_screen")
    object SignUpScreen : NavScreens("sign_up_screen")
}