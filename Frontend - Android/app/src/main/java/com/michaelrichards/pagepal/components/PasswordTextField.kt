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
    passwordHidden: MutableState<Boolean>,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        modifier = modifier,
        value = textValueState.value,
        label = { Text(text = label, style = MaterialTheme.typography.labelMedium) },
        onValueChange = { textValueState.value = it.filterCharacters() },
        enabled = enabled.value,
        maxLines = 1,
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable { passwordHidden.value = !passwordHidden.value },
                imageVector = if (passwordHidden.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                contentDescription = stringResource(id = if (passwordHidden.value) R.string.showPassword else R.string.hidePassword)
            )
        },
        isError = isError.value,
        keyboardActions = keyboardActions,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Go
        ),
        visualTransformation = if (passwordHidden.value) PasswordVisualTransformation() else VisualTransformation.None
    )
}

private fun String.filterCharacters() =
    filter { char -> char.isLetterOrDigit() || "!@#\$%^&*()_-+=<>?".contains(char) }.trim()