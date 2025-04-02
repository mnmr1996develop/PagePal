package com.michaelrichards.pagepal.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.michaelrichards.pagepal.R
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun BirthdayField(modifier: Modifier = Modifier, onDateSelected: (String) -> Unit) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    var dateText by remember { mutableStateOf(TextFieldValue("")) }

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            calendar.set(year, month, dayOfMonth)
            val formattedDate = dateFormat.format(calendar.time)
            dateText = TextFieldValue(formattedDate)
            onDateSelected(formattedDate)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )


    OutlinedTextField(
        value = dateText,
        onValueChange = {},
        label = { Text(
            text = stringResource(R.string.select_birthday)
        ) },
        readOnly = true,
        modifier = modifier
            .clickable { datePickerDialog.show() }
    )

}
