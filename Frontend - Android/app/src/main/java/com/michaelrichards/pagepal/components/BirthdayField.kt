package com.michaelrichards.pagepal.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.michaelrichards.pagepal.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

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
