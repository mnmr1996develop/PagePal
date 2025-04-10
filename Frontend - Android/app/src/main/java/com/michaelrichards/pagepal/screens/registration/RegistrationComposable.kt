package com.michaelrichards.pagepal.screens.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.michaelrichards.pagepal.R
import com.michaelrichards.pagepal.components.AuthTextFields
import com.michaelrichards.pagepal.components.DatePickerField
import com.michaelrichards.pagepal.components.PasswordTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationComposable(
    modifier: Modifier = Modifier,
    firstName: MutableState<String>,
    lastName: MutableState<String>,
    username: MutableState<String>,
    email: MutableState<String>,
    birthday: DatePickerState,
    password: MutableState<String>,
    retypePassword: MutableState<String>,
    isEnabled: MutableState<Boolean>,
    isFirstNameError: MutableState<Boolean>,
    isLastNameError: MutableState<Boolean>,
    isUsernameError: MutableState<Boolean>,
    isPasswordError: MutableState<Boolean>,
    isEmailError: MutableState<Boolean>,
    onBackButtonPress: () -> Unit,
    onRegisterClick: () -> Unit
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = stringResource(R.string.go_back),
                    modifier = Modifier.clickable {
                        onBackButtonPress()
                    }
                )
            }
        },
        bottomBar = {
            Button(
                onClick = onRegisterClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(stringResource(R.string.register))
            }
        }
    ) { paddingValues ->


        val scrollState = rememberScrollState()

        val showPassword = remember { mutableStateOf(false) }


        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = stringResource(R.string.app_icon)
            )

            AuthTextFields(
                modifier = Modifier.fillMaxWidth(),
                textValueState = firstName,
                label = stringResource(R.string.first_name),
                enabled = isEnabled,
                isError = isFirstNameError,
                trailingIcon = Icons.Filled.AccountCircle
            )

            Spacer(modifier = Modifier.height(8.dp))

            AuthTextFields(
                modifier = Modifier.fillMaxWidth(),
                textValueState = lastName,
                label = stringResource(R.string.last_name),
                enabled = isEnabled,
                isError = isLastNameError,
                trailingIcon = Icons.Filled.AccountCircle
            )

            Spacer(modifier = Modifier.height(8.dp))

            AuthTextFields(
                modifier = Modifier.fillMaxWidth(),
                textValueState = username,
                label = stringResource(R.string.username),
                enabled = isEnabled,
                isError = isUsernameError,
                trailingIcon = Icons.Filled.AccountCircle
            )

            Spacer(modifier = Modifier.height(8.dp))

            AuthTextFields(
                modifier = Modifier.fillMaxWidth(),
                textValueState = email,
                label = stringResource(R.string.email),
                enabled = isEnabled,
                isError = isEmailError,
                trailingIcon = Icons.Filled.Email
            )

            Spacer(modifier = Modifier.height(8.dp))

            DatePickerField(
                modifier = Modifier.fillMaxWidth(),
                datePickerState = birthday
            )

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                textValueState = password,
                label = stringResource(R.string.password),
                enabled = isEnabled,
                isError = isPasswordError,
                showPassword = showPassword
            )

            Spacer(modifier = Modifier.height(8.dp))

            PasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                textValueState = retypePassword,
                label = stringResource(R.string.retype_password),
                enabled = isEnabled,
                isError = isPasswordError,
                showPassword = showPassword,
                imeAction = ImeAction.Go,
                keyboardActions = KeyboardActions(
                    onGo = {
                        if (isEnabled.value){
                            onRegisterClick()
                        }
                    }
                )
            )
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun PreviewRegistration() {

    val firstName = remember { mutableStateOf("Michael") }
    val lastName = remember { mutableStateOf("Richards") }
    val email = remember { mutableStateOf("mnmr1996development@mail.com") }
    val username = remember { mutableStateOf("mnmr1996develop") }
    val password = remember { mutableStateOf("mnmr1996develop") }
    val retypePassword = remember { mutableStateOf("mnmr1996develop") }
    val enabled = remember { mutableStateOf(true) }


    val isFirstNameError = remember { mutableStateOf(false) }
    val isLastNameError = remember { mutableStateOf(false) }
    val isUsernameError = remember { mutableStateOf(false) }
    val isEmailError = remember { mutableStateOf(false) }


    val isPasswordError = remember { mutableStateOf(false) }

    val birthday = rememberDatePickerState(
        selectableDates = PastOrPresentSelectableDates
    )

    RegistrationComposable(
        onBackButtonPress = {

        },
        firstName = firstName,
        lastName = lastName,
        username = username,
        email = email,
        birthday = birthday,
        password = password,
        retypePassword = retypePassword,
        isEnabled = enabled,
        isFirstNameError = isFirstNameError,
        isLastNameError = isLastNameError,
        isUsernameError = isUsernameError,
        isPasswordError = isPasswordError,
        isEmailError = isEmailError,
    ) {

    }
}