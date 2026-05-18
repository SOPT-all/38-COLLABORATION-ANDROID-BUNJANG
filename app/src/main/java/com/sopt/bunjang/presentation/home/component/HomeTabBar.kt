package com.sopt.bunjang.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun HomeTabBar(
    modifier: Modifier = Modifier
) {
    var textWidth by remember { mutableIntStateOf(0) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(BunjangTheme.colors.white),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.width(21.dp))

        Text(
            text = "야구 페스타",
            style = BunjangTheme.typography.body.body1,
            color = BunjangTheme.colors.darkRed
        )

        Spacer(modifier = Modifier.width(20.dp))

        Column {
            Text(
                text = "추천",
                style = BunjangTheme.typography.body.body1_1,
                color = BunjangTheme.colors.gray900,
                onTextLayout = { textLayoutResult ->
                    textWidth = textLayoutResult.size.width
                }
            )
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .width(with(LocalDensity.current) { textWidth.toDp() })
                    .height(3.dp)
                    .background(BunjangTheme.colors.gray900)
            )
        }

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = "하이엔드",
            style = BunjangTheme.typography.body.body1,
            color = BunjangTheme.colors.gray800
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = "메루카리",
            style = BunjangTheme.typography.body.body1,
            color = BunjangTheme.colors.gray800
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = "오늘특가",
            style = BunjangTheme.typography.body.body1,
            color = BunjangTheme.colors.gray800
        )

        Spacer(modifier = Modifier.width(21.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeTabBar() {
    BunjangTheme {
        HomeTabBar(modifier = Modifier)
    }
}