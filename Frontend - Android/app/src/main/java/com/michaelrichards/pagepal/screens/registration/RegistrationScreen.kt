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
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
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
import com.michaelrichards.pagepal.components.BirthdayField
import com.michaelrichards.pagepal.components.PasswordTextField

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val retypePassword = remember { mutableStateOf("") }
    val enabled = remember { mutableStateOf(true) }


    val firstNameError = remember { mutableStateOf(false) }
    val lastNameError = remember { mutableStateOf(false) }
    val usernameError = remember { mutableStateOf(false) }
    val emailError = remember { mutableStateOf(false) }

    val showPassword = remember { mutableStateOf(false) }

    val isPasswordError = remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()


    Scaffold(
        modifier = modifier,
        topBar = {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier.clickable {
                        navController.navigateUp()
                    },
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = stringResource(R.string.go_back)
                )
            }
        },
        bottomBar = {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(stringResource(R.string.register))
            }
        }
    ) { paddingValues ->



        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(250.dp),
                imageVector = Icons.Filled.Book,
                contentDescription = stringResource(R.string.app_icon)
            )

            Column(
                modifier = Modifier.verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AuthTextFields(
                    modifier = Modifier.fillMaxWidth(),
                    textValueState = firstName,
                    label = stringResource(R.string.first_name),
                    enabled = enabled,
                    isError = firstNameError,
                    trailingIcon = Icons.Filled.AccountCircle
                )

                Spacer(modifier = Modifier.height(8.dp))

                AuthTextFields(
                    modifier = Modifier.fillMaxWidth(),
                    textValueState = lastName,
                    label = stringResource(R.string.last_name),
                    enabled = enabled,
                    isError = lastNameError,
                    trailingIcon = Icons.Filled.AccountCircle
                )

                Spacer(modifier = Modifier.height(8.dp))

                AuthTextFields(
                    modifier = Modifier.fillMaxWidth(),
                    textValueState = username,
                    label = stringResource(R.string.username),
                    enabled = enabled,
                    isError = usernameError,
                    trailingIcon = Icons.Filled.AccountCircle
                )

                Spacer(modifier = Modifier.height(8.dp))

                AuthTextFields(
                    modifier = Modifier.fillMaxWidth(),
                    textValueState = email,
                    label = stringResource(R.string.email),
                    enabled = enabled,
                    isError = emailError,
                    trailingIcon = Icons.Filled.Email
                )

                Spacer(modifier = Modifier.height(8.dp))

                PasswordTextField(
                    modifier = Modifier.fillMaxWidth(),
                    textValueState = password,
                    label = stringResource(R.string.password),
                    enabled = enabled,
                    isError = isPasswordError,
                    passwordHidden = showPassword,
                    keyboardActions = KeyboardActions {

                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                BirthdayField(
                    modifier = Modifier.fillMaxWidth()
                ) {

                }

                Spacer(modifier = Modifier.height(8.dp))



                PasswordTextField(
                    modifier = Modifier.fillMaxWidth(),
                    textValueState = retypePassword,
                    label = stringResource(R.string.retype_password),
                    enabled = enabled,
                    isError = isPasswordError,
                    passwordHidden = showPassword,
                    keyboardActions = KeyboardActions {

                    }
                )

                Spacer(modifier = Modifier.height(8.dp))


            }
        }


    }

}



@Preview
@Composable
private fun PreviewRegistrationScreen(

) {
    RegistrationScreen(
        navController = NavController(LocalContext.current)
    )
}