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
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.michaelrichards.pagepal.R
import com.michaelrichards.pagepal.components.AuthTextFields
import com.michaelrichards.pagepal.components.PasswordTextField

@Composable
fun LoginComposable(
    modifier: Modifier = Modifier,
    username: MutableState<String>,
    password: MutableState<String>,
    isEnabled: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    onSignUpClicked: ()-> Unit,
    onLoginClicked: () -> Unit
) {

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
                    onClick = onSignUpClicked
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
                showPasswod = isPasswordHidden,
                keyboardActions = KeyboardActions { }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onLoginClicked
            ) {
                Text(stringResource(R.string.login))
            }


        }
    }
}

@Preview
@Composable
private fun PreviewLoginScreen() {

    val username = remember { mutableStateOf("username") }
    val password = remember { mutableStateOf("password") }
    val enabled = remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(false) }


    LoginComposable(
        onSignUpClicked = {},
        modifier = Modifier.fillMaxSize(),
        username = username,
        password = password,
        isEnabled = enabled,
        isError = isError
    ) { }
}