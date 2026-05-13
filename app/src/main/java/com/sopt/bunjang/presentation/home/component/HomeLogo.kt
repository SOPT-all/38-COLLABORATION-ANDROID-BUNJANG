package com.sopt.bunjang.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun HomeLogo(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(
                color = BunjangTheme.colors.gray100,
                shape = RoundedCornerShape(16.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(top = 2.dp, bottom = 2.dp, start = 2.dp)
                .background(
                    color = BunjangTheme.colors.black,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Text(
                text = "번개장터",
                color = BunjangTheme.colors.white,
                style = BunjangTheme.typography.body.body2_1,
                modifier = Modifier.padding(vertical = 6.dp, horizontal = 14.dp)
            )
        }

        Text(
            text = "EDITION 1",
            color = BunjangTheme.colors.gray600,
            style = BunjangTheme.typography.body.body4,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 9.dp, start = 13.dp, end = 15.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun HomeLogoPreview() {
    BunjangTheme {
        HomeLogo()
    }
}