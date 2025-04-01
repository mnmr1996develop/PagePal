package com.michaelrichards.pagepal.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DeepIndigo80,
    onPrimary = DeepIndigo20,
    primaryContainer = DeepIndigo30,
    onPrimaryContainer = DeepIndigo90,
    inversePrimary = DeepIndigo40,
    secondary = MutedLavender80,
    onSecondary = MutedLavender20,
    secondaryContainer = MutedLavender30,
    onSecondaryContainer = MutedLavender90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Grey10,
    onBackground = Grey90,
    surface = DeepIndigoGrey30,
    onSurface = DeepIndigoGrey80,
    inverseSurface = Grey90,
    inverseOnSurface = Grey10,
    surfaceVariant = DeepIndigoGrey30,
    onSurfaceVariant = DeepIndigoGrey80,
    outline = BurntOrange
)

private val LightColorScheme = lightColorScheme(
    primary = DeepIndigo40,
    onPrimary = Color.White,
    primaryContainer = DeepIndigo90,
    onPrimaryContainer = DeepIndigo10,
    inversePrimary = DeepIndigo80,
    secondary = MutedLavender40,
    onSecondary = Color.White,
    secondaryContainer = MutedLavender90,
    onSecondaryContainer = MutedLavender10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Grey99,
    onBackground = Grey10,
    surface = DeepIndigoGrey90,
    onSurface = DeepIndigoGrey30,
    inverseSurface = Grey20,
    inverseOnSurface = Grey95,
    surfaceVariant = DeepIndigoGrey90,
    onSurfaceVariant = DeepIndigoGrey30,
    outline = BurntOrange
)

@Composable
fun PagePalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}