package com.ortalesoft.letsshop.presentation.screens.dashboard

import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ortalesoft.letsshop.R

import com.ortalesoft.letsshop.presentation.navigation.app.AppNavigation
import com.ortalesoft.letsshop.presentation.navigation.app.AppScreens
import com.ortalesoft.letsshop.presentation.navigation.app.BottomNavItem
import com.ortalesoft.letsshop.presentation.navigation.app.currentRoute

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    DashboardScreenContent(
        modifier = modifier,
        navController = navController
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreenContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val bottomNavController = rememberNavController()

    val items = listOf(
        BottomNavItem(
            title = "Lists",
            route = AppScreens.ListsScreen.route,
            iconRes = R.drawable.list_active
        ),
        BottomNavItem(
            title = "Profile",
            route = AppScreens.ProfileScreen.route,
            iconRes = R.drawable.user_inactive
        )
    )

    Scaffold(
        // TOP BAR
        topBar = {
            TopAppBar(
                title = {
                    Text("Your lists")
                }
            )
        },

        // BOTTOM NAV
        bottomBar = {
            NavigationBar {
                val currentRoute = currentRoute(bottomNavController)

                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            bottomNavController.navigate(item.route) {
                                popUpTo(bottomNavController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.iconRes),
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }

    ) { padding ->
        AppNavigation(
            modifier = modifier.padding(padding),
            navController = bottomNavController
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DashboardScreenScreenPreview() {
    DashboardScreenContent(
        navController = rememberNavController()
    )
}