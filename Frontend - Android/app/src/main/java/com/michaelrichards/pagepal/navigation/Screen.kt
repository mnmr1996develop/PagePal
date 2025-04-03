package com.michaelrichards.pagepal.navigation

sealed class Screen(
    val route: String
){
    data object LoginScreen: Screen("login-screen")
    data object SplashScreen: Screen("splash-screen")
    data object HomeScreen: Screen("home-screen")
    data object RegistrationScreen: Screen("registration-screen")
}
