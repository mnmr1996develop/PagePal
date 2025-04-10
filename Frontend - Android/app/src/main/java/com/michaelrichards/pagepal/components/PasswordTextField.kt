package com.michaelrichards.pagepal.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.michaelrichards.pagepal.R

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    textValueState: MutableState<String>,
    label: String,
    enabled: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    showPassword: MutableState<Boolean>,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        modifier = modifier,
        value = textValueState.value,
        label = { Text(text = label, style = MaterialTheme.typography.labelMedium) },
        onValueChange = { textValueState.value = it.filterCharacters() },
        enabled = enabled.value,
        singleLine = true,
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable { showPassword.value = !showPassword.value },
                imageVector = if (showPassword.value) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                contentDescription = stringResource(id = if (showPassword.value) R.string.hidePassword else R.string.showPassword)
            )
        },
        isError = isError.value,
        keyboardActions = keyboardActions,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        visualTransformation = if (showPassword.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

private fun String.filterCharacters() =
    filter { char -> char.isLetterOrDigit() || "!@#\$%^&*()_-+=<>?".contains(char) }.trim()