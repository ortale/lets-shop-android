package com.ortalesoft.letsshop.presentation.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoadingViewModel = hiltViewModel()
) {

}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen(
        navController = rememberNavController()
    )
}