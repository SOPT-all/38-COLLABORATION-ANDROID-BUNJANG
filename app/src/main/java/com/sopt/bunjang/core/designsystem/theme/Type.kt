package com.sopt.bunjang.core.designsystem.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.sopt.bunjang.R

object BunjangFont {
    val bold = FontFamily(Font(R.font.pretendard_bold))
    val medium = FontFamily(Font(R.font.pretendard_medium))
    val regular = FontFamily(Font(R.font.pretendard_regular))
    val semibold = FontFamily(Font(R.font.pretendard_semibold))
}

sealed interface TypographyTokens {
    @Immutable
    data class Title(
        val b19: TextStyle,
        val b18: TextStyle,
        val b16: TextStyle,
        val sb16: TextStyle,
        val b14: TextStyle,
        val sb14: TextStyle
    ) : TypographyTokens

    @Immutable
    data class Body(
        val m14: TextStyle,
        val b14_1: TextStyle,
        val sb12: TextStyle,
        val sb12_1: TextStyle,
        val r12: TextStyle,
        val m11: TextStyle,
        val m11_1: TextStyle,
        val m10: TextStyle
    ) : TypographyTokens

    @Immutable
    data class Label(
        val b11: TextStyle,
        val sb11: TextStyle,
        val b10: TextStyle,
        val r10: TextStyle
    ) : TypographyTokens
}

@Immutable
data class BunjangTypography(
    val title: TypographyTokens.Title,
    val body: TypographyTokens.Body,
    val label: TypographyTokens.Label
)

private fun bunjangTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit,
    letterSpacing: TextUnit
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing
)

val defaultBunjangTypography = BunjangTypography(
    title = TypographyTokens.Title(
        b19 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 19.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.01.em
        ),
        b18 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 18.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.03).em
        ),
        b16 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 16.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.02).em
        ),
        sb16 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 16.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.03).em
        ),
        b14 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 14.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.02).em
        ),
        sb14 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 14.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.02).em
        ),
    ),

    body = TypographyTokens.Body(
        m14 = bunjangTextStyle(
            fontFamily = BunjangFont.medium,
            fontSize = 14.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.01).em
        ),
        b14_1 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 14.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.01).em
        ),
        sb12 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 12.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.02.em
        ),
        sb12_1 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 12.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.03).em
        ),
        r12 = bunjangTextStyle(
            fontFamily = BunjangFont.regular,
            fontSize = 12.sp,
            lineHeight = 1.5.em,
            letterSpacing = 0.em
        ),
        m11 = bunjangTextStyle(
            fontFamily = BunjangFont.medium,
            fontSize = 11.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.01).em
        ),
        m11_1 = bunjangTextStyle(
            fontFamily = BunjangFont.medium,
            fontSize = 11.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.01.em
        ),
        m10 = bunjangTextStyle(
            fontFamily = BunjangFont.medium,
            fontSize = 10.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.02.em
        ),
    ),

    label = TypographyTokens.Label(
        b11 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 11.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.01.em
        ),
        sb11 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 11.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.02).em
        ),
        b10 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 10.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.03).em
        ),
        r10 = bunjangTextStyle(
            fontFamily = BunjangFont.regular,
            fontSize = 10.sp,
            lineHeight = 1.5.em,
            letterSpacing = (-0.04).em
        ),
    )

)

@Preview(showBackground = true)
@Composable
private fun BunjangTypographyPreview() {
    BunjangTheme {
        Column(
            modifier = Modifier
                .background(BunjangTheme.colors.white)
                .padding(8.dp)
        ) {
            Text("Title b19", style = BunjangTheme.typography.title.b19)
            Text("Title b18", style = BunjangTheme.typography.title.b18)
            Text("Title b16", style = BunjangTheme.typography.title.b16)
            Text("Title sb16", style = BunjangTheme.typography.title.sb16)
            Text("Title b14", style = BunjangTheme.typography.title.b14)
            Text("Title sb14", style = BunjangTheme.typography.title.sb14)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Body m14", style = BunjangTheme.typography.body.m14)
            Text("Body b14_1", style = BunjangTheme.typography.body.b14_1)
            Text("Body sb12", style = BunjangTheme.typography.body.sb12)
            Text("Body sb12_1", style = BunjangTheme.typography.body.sb12_1)
            Text("Body r12", style = BunjangTheme.typography.body.r12)
            Text("Body m11", style = BunjangTheme.typography.body.m11)
            Text("Body m11_1", style = BunjangTheme.typography.body.m11_1)
            Text("Body m10", style = BunjangTheme.typography.body.m10)

            Spacer(modifier = Modifier.height(8.dp))

            Text("label b11", style = BunjangTheme.typography.label.b11)
            Text("label sb11", style = BunjangTheme.typography.label.sb11)
            Text("label b10", style = BunjangTheme.typography.label.b10)
            Text("label r10", style = BunjangTheme.typography.label.r10)
        }
    }
}