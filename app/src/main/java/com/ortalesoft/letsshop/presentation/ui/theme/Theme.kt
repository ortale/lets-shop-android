package com.ortalesoft.letsshop.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = CoralRed,
    onPrimary = Color.White,
    primaryContainer = CoralRedLight,
    onPrimaryContainer = CoralRed,

    secondary = MintGreen,
    onSecondary = Color.White,
    secondaryContainer = MintGreenLight,
    onSecondaryContainer = MintGreen,

    tertiary = SunshineYellow,
    onTertiary = DarkText,

    background = Color.White,
    onBackground = DarkText,

    surface = Color.White,
    onSurface = DarkText,
    surfaceVariant = CoralRedLight,
    onSurfaceVariant = SecondaryText,

    outline = BorderColor,
)

private val DarkColorScheme = darkColorScheme(
    primary = CoralRedDark,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF5A1A1A),
    onPrimaryContainer = CoralRedDark,

    secondary = MintGreenDark,
    onSecondary = DarkText,
    secondaryContainer = Color(0xFF003D2E),
    onSecondaryContainer = MintGreenDark,

    tertiary = SunshineYellowDark,
    onTertiary = DarkText,

    background = Color(0xFF121212),
    onBackground = DarkTextDark,

    surface = Color(0xFF1E1E1E),
    onSurface = DarkTextDark,
    surfaceVariant = Color(0xFF2A2A2A),
    onSurfaceVariant = SecondaryTextDark,

    outline = BorderColorDark,
)

@Composable
fun LetsShopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = LetsShopTypography,
        content = content
    )
}