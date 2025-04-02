package com.michaelrichards.pagepal.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Book
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.michaelrichards.pagepal.R
import com.michaelrichards.pagepal.components.AuthTextFields
import com.michaelrichards.pagepal.components.PasswordTextField
import com.michaelrichards.pagepal.navigation.Screen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val isEnabled = remember { mutableStateOf(true) }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }
    val isPasswordHidden = remember { mutableStateOf(true) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                OutlinedButton(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    onClick = {
                        navController.navigate(Screen.RegistrationScreen.route)
                    }
                ) {
                    Text(text = stringResource(R.string.sign_up))
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(200.dp),
                imageVector = Icons.Filled.Book,
                contentDescription = stringResource(R.string.app_icon)
            )


            AuthTextFields(
                textValueState = username,
                label = stringResource(R.string.username),
                modifier = Modifier.fillMaxWidth(),
                enabled = isEnabled,
                isError = isError,
                trailingIcon = Icons.Filled.AccountCircle,
            )

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                textValueState = password,
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(R.string.password),
                enabled = isEnabled,
                isError = isError,
                passwordHidden = isPasswordHidden,
                keyboardActions = KeyboardActions { }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {

                }
            ) {
                Text(stringResource(R.string.login))
            }


        }
    }
}

@Preview
@Composable
private fun PreviewLoginScreen() {
    LoginScreen(
        navController = NavController(LocalContext.current)
    )
}