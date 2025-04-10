package com.michaelrichards.pagepal.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AuthTextFields(
    modifier: Modifier = Modifier,
    textValueState: MutableState<String>,
    label: String,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: MutableState<Boolean>,
    isError: MutableState<Boolean>,
    trailingIcon: ImageVector
) {

    OutlinedTextField(
        modifier = modifier,
        value = textValueState.value,
        label = { Text(text = label) },
        isError = isError.value,
        trailingIcon = {
            Icon(
                imageVector = trailingIcon,
                contentDescription = null
            )
        },
        singleLine = true,
        enabled = enabled.value,
        onValueChange = {textValueState.value = it},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = imeAction),
        keyboardActions = keyboardActions,
    )

}

@Preview
@Composable
private fun PreviewAuthTextFields() {

    val text = remember { mutableStateOf("mnmr1996") }
    val enabled = remember { mutableStateOf(true) }
    val isError = remember { mutableStateOf(false) }

    AuthTextFields(
        textValueState = text,
        label = "username",
        enabled = enabled,
        isError = isError,
        trailingIcon = Icons.TwoTone.AccountCircle
    )
}