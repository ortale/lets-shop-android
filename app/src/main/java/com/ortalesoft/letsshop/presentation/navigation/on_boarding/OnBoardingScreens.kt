package com.ortalesoft.letsshop.presentation.navigation.on_boarding

sealed class OnBoardingScreens(val route: String) {
    object SignInScreen : OnBoardingScreens("sign_in_screen")
    object SignUpScreen : OnBoardingScreens("sign_up_screen")
    object DashboardScreen : OnBoardingScreens("dashboard_screen")
}