package com.ortalesoft.letsshop.presentation.navigation.app

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val title: String,
    val route: String,
    @DrawableRes val iconRes: Int
)
