package com.ortalesoft.letsshop.presentation.screens.dashboard.shopping_lists

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun ShoppingListsScreen(
    modifier: Modifier = Modifier,
    viewModel: ShoppingListsViewModel = hiltViewModel()
) {
    val shoppingListsScreenState by viewModel.shoppingListsScreenState.collectAsState()

    ShoppingListsScreenContent(
        modifier = modifier,
        shoppingListsScreenState = shoppingListsScreenState
    )
}

@Composable
private fun ShoppingListsScreenContent(
    modifier: Modifier = Modifier,
    shoppingListsScreenState: ShoppingListsScreenState
) {
    when (shoppingListsScreenState) {
        is ShoppingListsScreenState.Idle -> {}
        is ShoppingListsScreenState.Loading -> {}
        is ShoppingListsScreenState.Success -> {}
        is ShoppingListsScreenState.Error -> {}
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .imePadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Shopping Lists Screen",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListsScreenPreview() {
    ShoppingListsScreenContent(
        shoppingListsScreenState = ShoppingListsScreenState.Idle
    )
}