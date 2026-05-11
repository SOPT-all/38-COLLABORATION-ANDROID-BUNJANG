package com.sopt.bunjang.core.designsystem.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Immutable
data class BunjangColors(
    val gray900: Color,
    val gray800: Color,
    val gray700: Color,
    val gray600: Color,
    val gray500: Color,
    val gray400: Color,
    val gray300: Color,
    val gray200: Color,
    val gray100: Color,
    val gray500_70: Color,

    val black: Color,
    val white: Color,
    val white_70: Color,
    val black_15: Color,

    val darkRed: Color,
    val primaryRed: Color,
    val lightRed: Color,

    val mint: Color,
    val yellow: Color,
    val lightYellow: Color,
    val lightBlue: Color,
)

val defaultBunjangColors = BunjangColors(
    gray900 = Color(0xFF191919),
    gray800 = Color(0xFF4C4C4C),
    gray700 = Color(0xFF666666),
    gray600 = Color(0xFF8C8C8C),
    gray500 = Color(0xFF999999),
    gray400 = Color(0xFFB2B2B2),
    gray300 = Color(0xFFCCCCCC),
    gray200 = Color(0xFFE5E5E5),
    gray100 = Color(0xFFF6F6F6),
    gray500_70 = Color(0xFF999999).copy(alpha = 0.7f),

    black = Color(0xFF000000),
    white = Color(0xFFFFFFFF),
    white_70 = Color(0xFFFFFFFF).copy(alpha = 0.7f),
    black_15 = Color(0xFF000000).copy(alpha = 0.15f),

    darkRed = Color(0xFFD00F1C),
    primaryRed = Color(0xFFD80C18),
    lightRed = Color(0xFFFFEFF0),

    mint = Color(0xFF00A587),
    yellow = Color(0xFFFFC200),
    lightYellow = Color(0xFFFFE1A6),
    lightBlue = Color(0xFFEFF2FE),
)

@Preview(showBackground = true)
@Composable
private fun BunjangColorsPreview() {
    BunjangTheme {
        Column {
            listOf(
                BunjangTheme.colors.gray900,
                BunjangTheme.colors.gray800,
                BunjangTheme.colors.gray700,
                BunjangTheme.colors.gray600,
                BunjangTheme.colors.gray500,
                BunjangTheme.colors.gray400,
                BunjangTheme.colors.gray300,
                BunjangTheme.colors.gray200,
                BunjangTheme.colors.gray100,
                BunjangTheme.colors.gray500_70,

                BunjangTheme.colors.black,
                BunjangTheme.colors.white,
                BunjangTheme.colors.white_70,
                BunjangTheme.colors.black_15,

                BunjangTheme.colors.darkRed,
                BunjangTheme.colors.primaryRed,
                BunjangTheme.colors.lightRed,

                BunjangTheme.colors.mint,
                BunjangTheme.colors.yellow,
                BunjangTheme.colors.lightYellow,
                BunjangTheme.colors.lightBlue,
            ).chunked(6).forEach { rowColors ->
                Row(modifier = Modifier.padding(vertical = 4.dp)) {
                    rowColors.forEach { c ->
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(c)
                                .padding(end = 8.dp),
                        )
                    }
                }
            }
        }
    }
}