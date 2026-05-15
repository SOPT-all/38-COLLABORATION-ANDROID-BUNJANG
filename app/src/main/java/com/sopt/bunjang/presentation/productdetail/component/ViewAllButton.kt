package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun ViewAllButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    textColor: Color = BunjangTheme.colors.gray800,
    backgroundColor: Color = BunjangTheme.colors.gray100
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(6.dp))
            .background(color = backgroundColor)
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = text,
            color = textColor,
            style = BunjangTheme.typography.title.title5
        )
    }
}

@Preview
@Composable
private fun ViewAllButtonPreview() {
    BunjangTheme {
        ViewAllButton(
            text = "상품 전체보기"
        )
    }
}
