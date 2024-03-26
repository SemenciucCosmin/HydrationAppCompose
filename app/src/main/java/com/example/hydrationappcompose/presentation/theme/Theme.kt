package com.example.hydrationappcompose.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF40F589),
    onPrimary = Color(0xFF000000), // Button text

    secondaryContainer = Color(0x00000000), // Indicator color for bottom navigation item
    onSecondaryContainer = Color(0xFFFFFFFF), // Bottom navigation item color

    background = Color(0xFF171717),
    onBackground = Color(0xFF9E9E9E),

    surface = Color(0xFF0F0F0F),
    onSurface = Color(0xFFFFFFFF),

    onSurfaceVariant = Color(0xFF5E5E5E), // Unselected bottom navigation item, Top bar action item

    surfaceTint = Color(0xFF0F0F0F), // Bottom navigation tint

    outlineVariant = Color(0xFF9E9E9E), // Horizontal divider

    error = Color(0xFFF54040)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00B13A),
    onPrimary = Color(0xFFFFFFFF),

    secondaryContainer = Color(0x00000000),
    onSecondaryContainer = Color(0xFF000000),

    background = Color(0xFFE8E8E8),
    onBackground = Color(0xFF616161),

    surface = Color(0xFFF0F0F0),
    onSurface = Color(0xFF000000),

    onSurfaceVariant = Color(0xFFA1A1A1),

    surfaceTint = Color(0xFFF0F0F0),

    outlineVariant = Color(0xFF616161),

    error = Color(0xFFB10000)
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