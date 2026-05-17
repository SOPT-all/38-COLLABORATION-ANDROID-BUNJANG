package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun ProductDetailTabRow(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 19.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "상세정보",
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 11.dp),
                textAlign = TextAlign.Center,
                style = BunjangTheme.typography.title.title5,
                color = BunjangTheme.colors.gray900
            )

            Text(
                text = "상점정보/후기",
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 11.dp),
                textAlign = TextAlign.Center,
                style = BunjangTheme.typography.title.title6,
                color = BunjangTheme.colors.gray800
            )
        }

        HorizontalDivider(
            color = BunjangTheme.colors.gray900,
            thickness = 3.dp,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .clip(RoundedCornerShape(100.dp))
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
private fun ProductDetailTabRowPreview() {
    BunjangTheme {
        ProductDetailTabRow()
    }
}