package com.michaelrichards.pagepal.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.michaelrichards.pagepal.components.LoadingWithOpaqueBackground
import com.michaelrichards.pagepal.navigation.Screen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    val isEnabled = loginViewModel.isEnabled
    val username = loginViewModel.username
    val password = loginViewModel.password
    val isLoading = loginViewModel.isLoading
    val isError =   loginViewModel.isError

    LaunchedEffect(true) {

    }

    LoadingWithOpaqueBackground(
        isLoading = isLoading
    ) {
        LoginComposable(
            modifier = modifier,
            username = username,
            password = password,
            isEnabled = isEnabled,
            isError = isError,
            onSignUpClicked = {
                navController.navigate(Screen.RegistrationScreen.route)
            },
            onLoginClicked = {
                loginViewModel.login()
            }
        )
    }

}