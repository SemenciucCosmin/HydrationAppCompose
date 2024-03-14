package com.example.hydrationappcompose.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF40F589),

    secondaryContainer = Color(0x00000000),
    onSecondaryContainer = Color(0xFFFFFFFF),

    background = Color(0xFF000000),
    onBackground = Color(0xFF7C7C7C),

    surface = Color(0xFF101010),
    onSurface = Color(0xFFFFFFFF),

    onSurfaceVariant = Color(0xFF6C6C6C),

    surfaceTint = Color(0xFF101010)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00B13A),

    secondaryContainer = Color(0x00000000),
    onSecondaryContainer = Color(0xFF000000),

    background = Color(0xFFEFEFEF),
    onBackground = Color(0xFF5E5E5E) ,

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF000000),

    onSurfaceVariant = Color(0xFFA6A6A6),

    surfaceTint = Color(0xFFFFFFFF)
)

@Composable
fun HydrationAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}