package com.michaelrichards.pagepal.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.michaelrichards.pagepal.navigation.Graph

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val isEnabled = remember { mutableStateOf(true) }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }


    LoginComposable(
        modifier = modifier,
        username = username,
        password = password,
        isEnabled = isEnabled,
        isError = isError,
        onSignUpClicked = { TODO() },
        onLoginClicked = {
            navController.navigate(Graph.Main.graphName){
                popUpTo(Graph.Auth.graphName){
                    inclusive = true
                }
            }
        }
    )
}