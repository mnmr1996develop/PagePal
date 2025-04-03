package com.michaelrichards.pagepal.screens.registration

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.michaelrichards.pagepal.navigation.Graph
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
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


    val isFirstNameError = remember { mutableStateOf(false) }
    val isLastNameError = remember { mutableStateOf(false) }
    val isUsernameError = remember { mutableStateOf(false) }
    val isEmailError = remember { mutableStateOf(false) }


    val isPasswordError = remember { mutableStateOf(false) }


    val birthday = rememberDatePickerState(
        selectableDates = PastOrPresentSelectableDates
    )


    RegistrationComposable(
        modifier = modifier,
        onBackButtonPress = {
            navController.popBackStack()
        },
        firstName = firstName,
        lastName = lastName,
        username = username,
        email = email,
        birthday = birthday,
        password = password,
        retypePassword = retypePassword,
        enabled = enabled,
        isFirstNameError = isFirstNameError,
        isLastNameError = isLastNameError,
        isUsernameError = isUsernameError,
        isPasswordError = isPasswordError,
        isEmailError = isEmailError,
    ){
            navController.navigate(Graph.Main.graphName){
                popUpTo(Graph.Auth.graphName){
                    inclusive = true
                }
            }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
object PastOrPresentSelectableDates: SelectableDates {
    override fun isSelectableDate(utcTimeMillis: Long): Boolean {
        return utcTimeMillis <= System.currentTimeMillis()
    }

    override fun isSelectableYear(year: Int): Boolean {
        return year <= LocalDate.now().year
    }
}


