package com.sopt.bunjang.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalBunjangColors = staticCompositionLocalOf { defaultBunjangColors }

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
}

@Composable
fun ProvideBunjangColors(
    colors: BunjangColors = defaultBunjangColors,
    content: @Composable () -> Unit
){
    CompositionLocalProvider(
        LocalBunjangColors provides colors,
        content = content,
    )
}

@Composable
fun BunjangTheme(
    content: @Composable () -> Unit
) {
    ProvideBunjangColors {
        MaterialTheme(
            colorScheme = BunjangColorScheme,
            typography = Typography,
            content = content
        )
    }
}
