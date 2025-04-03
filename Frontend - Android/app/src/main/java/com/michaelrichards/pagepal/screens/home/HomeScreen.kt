package com.michaelrichards.pagepal.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->


        Box(
            modifier = Modifier.padding(paddingValues)
        ){
            Text("Home", style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    val navController = NavController(LocalContext.current)

    HomeScreen(navController = navController)
}