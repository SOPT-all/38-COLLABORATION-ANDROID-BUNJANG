package com.sopt.bunjang.presentation.purchase.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun PurchaseNoticeCard(
    userName: String,
    productName: String,
    time: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = BunjangTheme.colors.white,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = BunjangTheme.colors.gray100,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 12.dp, horizontal = 16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_complete_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(10.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "번개장터",
                    style = BunjangTheme.typography.label.label4,
                    color = BunjangTheme.colors.gray800
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = time,
                    style = BunjangTheme.typography.label.label4,
                    color = BunjangTheme.colors.gray400
                )
            }


            Spacer(modifier = Modifier.height(12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_detail_page_profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = userName,
                        style = BunjangTheme.typography.body.body2_1,
                        color = BunjangTheme.colors.gray900
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "'${productName}'의 결제가 완료되었어요.",
                        style = BunjangTheme.typography.body.body4,
                        color = BunjangTheme.colors.gray800
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PurchaseNoticeCardPreview() {
    BunjangTheme {
        PurchaseNoticeCard(
            userName = "혁줌마",
            productName = "안경닦이",
            time = "오후11:20"
        )
    }
}