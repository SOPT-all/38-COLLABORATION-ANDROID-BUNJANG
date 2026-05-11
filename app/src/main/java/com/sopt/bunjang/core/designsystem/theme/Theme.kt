package com.sopt.bunjang.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalBunjangColors = staticCompositionLocalOf { defaultBunjangColors }
val LocalBunjangTypography = staticCompositionLocalOf { defaultBunjangTypography }

private val BunjangColorScheme = lightColorScheme(
    primary = defaultBunjangColors.primaryRed,
    background = defaultBunjangColors.white,
    surface = defaultBunjangColors.white
)

object BunjangTheme {
    val colors: BunjangColors
        @Composable
        @ReadOnlyComposable
        get() = LocalBunjangColors.current
    val typography: BunjangTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalBunjangTypography.current
}

@Composable
fun ProvideBunjangTheme(
    colors: BunjangColors = defaultBunjangColors,
    typography: BunjangTypography = defaultBunjangTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalBunjangColors provides colors,
        LocalBunjangTypography provides typography,
        content = content,
    )
}

@Composable
fun BunjangTheme(
    content: @Composable () -> Unit
) {
    ProvideBunjangTheme {
        MaterialTheme(
            colorScheme = BunjangColorScheme,
            content = content
        )
    }
}
