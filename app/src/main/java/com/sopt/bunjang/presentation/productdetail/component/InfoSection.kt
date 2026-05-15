package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun InfoSection(
    categories: List<String>,
    condition: String,
    quantity: Int,
    description: String,
    deliveryFee: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 19.5.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "카테고리",
                color = BunjangTheme.colors.gray500,
                style = BunjangTheme.typography.body.body1,
            )

            Spacer(modifier = Modifier.width(24.dp))

            categories.forEachIndexed { index, category ->
                Text(
                    text = category,
                    color = BunjangTheme.colors.gray800,
                    textDecoration = TextDecoration.Underline,
                    style = BunjangTheme.typography.body.body2
                )

                Spacer(modifier = Modifier.width(2.dp))

                if (index < categories.lastIndex) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_detail_page_category_16),
                        contentDescription = null,
                        tint = BunjangTheme.colors.gray300,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "상품상태",
                color = BunjangTheme.colors.gray500,
                style = BunjangTheme.typography.body.body1,
            )

            Spacer(modifier = Modifier.width(24.dp))

            Text(
                text = condition,
                color = BunjangTheme.colors.gray800,
                style = BunjangTheme.typography.body.body2,
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "수량",
                modifier = Modifier.widthIn(min = 48.dp),
                color = BunjangTheme.colors.gray500,
                style = BunjangTheme.typography.body.body1,
            )

            Spacer(modifier = Modifier.width(24.dp))

            Text(
                text = "${quantity}개",
                color = BunjangTheme.colors.gray800,
                style = BunjangTheme.typography.body.body2,
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        description.split("\n").forEachIndexed { index, line ->
            if (index > 0) Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = line,
                color = BunjangTheme.colors.black,
                style = BunjangTheme.typography.title.title4
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column {
            Text(
                text = "배송비",
                color = BunjangTheme.colors.gray900,
                style = BunjangTheme.typography.title.title6
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "일반 %,d원".format(deliveryFee),
                color = BunjangTheme.colors.gray800,
                style = BunjangTheme.typography.body.body1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfoSectionPreview() {
    BunjangTheme {
        InfoSection(
            categories = listOf("패션 액세서리", "안경/선글라스", "안경"),
            condition = "사용감 적음",
            quantity = 1,
            description = "이펙터 코러스 GLCY컬러 판매합니다\n니콘 변색렌즈 장착되어있습니다",
            deliveryFee = 4000
        )
    }
}