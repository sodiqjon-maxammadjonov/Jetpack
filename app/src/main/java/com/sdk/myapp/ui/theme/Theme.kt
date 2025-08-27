package com.sdk.myapp.ui.theme

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
    primary = ElectricMint80,
    secondary = AquaGlow80,
    tertiary = SunsetOrange80,
    background = Color(0xFF0A0E1A),
    surface = Color(0xFF1A1F2E),
    onPrimary = Color(0xFF003D32),
    onSecondary = Color(0xFF004D40),
    onTertiary = Color(0xFF4A2C17),
    onBackground = Color(0xFF00E5A0),
    onSurface = Color(0xFF64FFDA),
)

private val LightColorScheme = lightColorScheme(
    primary = CyanWave40,
    secondary = DeepOcean40,
    tertiary = FireCoral40,
    // Kreativ kombinatsiya
    background = Color(0xFFF0F9FF),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    onTertiary = Color(0xFFFFFFFF),
    onBackground = Color(0xFF0A0E1A),
    onSurface = Color(0xFF1A1F2E),
)

@Composable
fun MyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
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