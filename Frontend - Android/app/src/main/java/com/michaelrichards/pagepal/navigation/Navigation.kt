package com.michaelrichards.pagepal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.michaelrichards.pagepal.screens.home.HomeScreen
import com.michaelrichards.pagepal.screens.login.LoginScreen
import com.michaelrichards.pagepal.screens.registration.RegistrationScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Graph.Auth.graphName) {

        navigation(
            route = Graph.Auth.graphName,
            startDestination = Screen.LoginScreen.route,
        ) {
            composable(route = Screen.LoginScreen.route) {
                LoginScreen(modifier = modifier, navController = navController)
            }

            composable(route = Screen.RegistrationScreen.route) {
                RegistrationScreen(modifier = modifier, navController = navController)
            }
        }

        navigation(
            route = Graph.Main.graphName,
            startDestination = Screen.HomeScreen.route
        ) {
            composable(route = Screen.HomeScreen.route){
                HomeScreen(modifier = modifier, navController = navController)
            }

        }

    }


}