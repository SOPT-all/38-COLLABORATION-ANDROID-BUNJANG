package com.sopt.bunjang.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun CartButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    textColor: Color = BunjangTheme.colors.primaryRed,
    backgroundColor: Color = BunjangTheme.colors.lightRed
) {
    Row(
        modifier = modifier
            .width(114.dp)
            .height(48.dp)
            .clip(shape = RoundedCornerShape(6.dp))
            .background(color = backgroundColor)
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = text,
            color = textColor,
            style = BunjangTheme.typography.title.title3
        )
    }
}

@Preview
@Composable
private fun CartButtonPreview() {
    BunjangTheme {
        CartButton(
            text = "장바구니"
        )
    }
}
