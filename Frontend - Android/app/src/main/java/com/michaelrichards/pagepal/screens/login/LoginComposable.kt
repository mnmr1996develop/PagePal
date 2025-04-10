package com.michaelrichards.pagepal.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    onSignUpClicked: () -> Unit,
    onLoginClicked: () -> Unit
) {

    val isPasswordHidden = remember { mutableStateOf(true) }
    val scrollState = rememberScrollState()


    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(R.string.app_icon),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

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
                showPassword = isPasswordHidden,
                keyboardActions = KeyboardActions { }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onLoginClicked
            ) {
                Text(stringResource(R.string.login), style = MaterialTheme.typography.bodyMedium)
            }


            Spacer(modifier = Modifier.height(32.dp))

            Text(text = stringResource(R.string.dont_have_an_account), style = MaterialTheme.typography.bodyMedium)

            OutlinedButton(
                onClick = onSignUpClicked
            ) {
                Text(text = stringResource(R.string.sign_up), modifier = Modifier.padding(horizontal = 32.dp), style = MaterialTheme.typography.bodyMedium)
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