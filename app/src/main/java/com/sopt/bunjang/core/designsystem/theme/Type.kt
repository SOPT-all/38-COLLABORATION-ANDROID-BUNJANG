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
        val title1: TextStyle,
        val title2: TextStyle,
        val title3: TextStyle,
        val title4: TextStyle,
        val title5: TextStyle,
        val title6: TextStyle
    ) : TypographyTokens

    @Immutable
    data class Body(
        val body1: TextStyle,
        val body1_1: TextStyle,
        val body2: TextStyle,
        val body2_1: TextStyle,
        val body3: TextStyle,
        val body4: TextStyle,
        val body4_1: TextStyle,
        val body5: TextStyle
    ) : TypographyTokens

    @Immutable
    data class Label(
        val label1: TextStyle,
        val label2: TextStyle,
        val label3: TextStyle,
        val label4: TextStyle
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
        title1 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 19.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.01.em
        ),
        title2 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 18.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.03).em
        ),
        title3 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 16.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.02).em
        ),
        title4 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 16.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.03).em
        ),
        title5 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 14.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.02).em
        ),
        title6 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 14.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.02).em
        ),
    ),

    body = TypographyTokens.Body(
        body1 = bunjangTextStyle(
            fontFamily = BunjangFont.medium,
            fontSize = 14.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.01).em
        ),
        body1_1 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 14.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.01).em
        ),
        body2 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 12.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.02.em
        ),
        body2_1 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 12.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.03).em
        ),
        body3 = bunjangTextStyle(
            fontFamily = BunjangFont.regular,
            fontSize = 12.sp,
            lineHeight = 1.5.em,
            letterSpacing = 0.em
        ),
        body4 = bunjangTextStyle(
            fontFamily = BunjangFont.medium,
            fontSize = 11.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.01).em
        ),
        body4_1 = bunjangTextStyle(
            fontFamily = BunjangFont.medium,
            fontSize = 11.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.01.em
        ),
        body5 = bunjangTextStyle(
            fontFamily = BunjangFont.medium,
            fontSize = 10.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.02.em
        ),
    ),

    label = TypographyTokens.Label(
        label1 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 11.sp,
            lineHeight = 1.35.em,
            letterSpacing = 0.01.em
        ),
        label2 = bunjangTextStyle(
            fontFamily = BunjangFont.semibold,
            fontSize = 11.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.02).em
        ),
        label3 = bunjangTextStyle(
            fontFamily = BunjangFont.bold,
            fontSize = 10.sp,
            lineHeight = 1.35.em,
            letterSpacing = (-0.03).em
        ),
        label4 = bunjangTextStyle(
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
            Text("Title1", style = BunjangTheme.typography.title.title1)
            Text("Title2", style = BunjangTheme.typography.title.title2)
            Text("Title3", style = BunjangTheme.typography.title.title3)
            Text("Title4", style = BunjangTheme.typography.title.title4)
            Text("Title5", style = BunjangTheme.typography.title.title5)
            Text("Title6", style = BunjangTheme.typography.title.title6)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Body1", style = BunjangTheme.typography.body.body1)
            Text("Body1-1", style = BunjangTheme.typography.body.body1_1)
            Text("Body2", style = BunjangTheme.typography.body.body2)
            Text("Body2-1", style = BunjangTheme.typography.body.body2_1)
            Text("Body3", style = BunjangTheme.typography.body.body3)
            Text("Body4", style = BunjangTheme.typography.body.body4)
            Text("Body4_1", style = BunjangTheme.typography.body.body4_1)
            Text("Body5", style = BunjangTheme.typography.body.body5)

            Spacer(modifier = Modifier.height(8.dp))

            Text("label1", style = BunjangTheme.typography.label.label1)
            Text("label2", style = BunjangTheme.typography.label.label2)
            Text("label3", style = BunjangTheme.typography.label.label3)
            Text("label4", style = BunjangTheme.typography.label.label4)
        }
    }
}