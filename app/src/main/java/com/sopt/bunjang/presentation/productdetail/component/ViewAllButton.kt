package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.core.extension.noRippleClickable

@Composable
fun ViewAllButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    textColor: Color = BunjangTheme.colors.gray800,
    backgroundColor: Color = BunjangTheme.colors.white
) {
    val text = buildAnnotatedString {
        append(text)
        withStyle(style = SpanStyle(color = BunjangTheme.colors.primaryRed)) {
            append(" 더보기")
        }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(6.dp))
            .border(
                width = 1.dp,
                color = BunjangTheme.colors.gray200,
                shape = RoundedCornerShape(6.dp)
            )
            .background(color = backgroundColor)
            .noRippleClickable(onClick = onClick)
            .padding(vertical = 11.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = text,
            color = textColor,
            style = BunjangTheme.typography.body.body2
        )

        Icon(
            painter = painterResource(R.drawable.ic_more_18),
            contentDescription = null,
            tint = BunjangTheme.colors.black,
            modifier = Modifier
                .size(18.dp)
                .padding(start = 4.dp)
        )
    }
}

@Preview
@Composable
private fun ViewAllButtonPreview() {
    BunjangTheme {
        ViewAllButton(
            text = "혁준마님 취향 상품 357개"
        )
    }
}
