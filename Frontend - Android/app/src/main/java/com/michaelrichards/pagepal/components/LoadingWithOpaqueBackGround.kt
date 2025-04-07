package com.michaelrichards.pagepal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.michaelrichards.pagepal.R

@Composable
fun LoadingWithOpaqueBackground(
    modifier: Modifier = Modifier,
    alpha: Float = 0.4f,
    isLoading: Boolean,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        content()
        if (isLoading) {
            Box(modifier = Modifier
                .matchParentSize()
                .background(Color.Gray.copy(alpha = alpha)))
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
                Text(text = stringResource(id = R.string.loading), style = MaterialTheme.typography.displayMedium)
            }
        }
    }
}