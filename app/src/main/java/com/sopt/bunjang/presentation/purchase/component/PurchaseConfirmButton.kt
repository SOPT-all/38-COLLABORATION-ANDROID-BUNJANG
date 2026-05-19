package com.sopt.bunjang.presentation.purchase.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.core.extension.noRippleClickable

@Composable
fun PurchaseConfirmButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = BunjangTheme.colors.primaryRed,
                shape = RoundedCornerShape(6.dp)
            )
            .noRippleClickable { onClick() }
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "거래 내역 확인",
            style = BunjangTheme.typography.title.title3,
            color = BunjangTheme.colors.white
        )
    }
}

@Preview
@Composable
private fun PurchaseConfirmButtonPreview() {
    BunjangTheme {
        PurchaseConfirmButton(onClick = {})
    }
}