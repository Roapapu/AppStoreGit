package com.example.fakestoreapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Black,
    onPrimary = White,
    secondary = GrayMedium,
    onSecondary = White,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    surfaceVariant = GrayLight,
    onSurfaceVariant = Black
)

@Composable
fun FakeStoreAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
