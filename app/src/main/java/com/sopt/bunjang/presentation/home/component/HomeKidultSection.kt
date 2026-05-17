package com.sopt.bunjang.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.component.ProductCard
import com.sopt.bunjang.core.designsystem.component.ProductCardType
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

data class HomeKidultProduct(
    val imageUrl: String,
    val price: Int,
    val title: String,
    val time: String? = null,
    val isLike: Boolean = false,
    val likes: Int? = null
)

@Composable
fun HomeKidultSection(
    modifier: Modifier = Modifier,
    homeKidultList: List<HomeKidultProduct>
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "키덜트 ",
                    style = BunjangTheme.typography.title.title3,
                    color = BunjangTheme.colors.primaryRed
                )
                Text(
                    text = "상품은 어때요?",
                    style = BunjangTheme.typography.title.title3,
                    color = BunjangTheme.colors.black
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 3.5.dp)
                        .background(
                            color = BunjangTheme.colors.gray200,
                            shape = RoundedCornerShape(1.dp)
                        )
                ) {
                    Text(
                        text = "AD",
                        style = BunjangTheme.typography.label.label3,
                        color = BunjangTheme.colors.gray600
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "더보기",
                    style = BunjangTheme.typography.label.label1,
                    color = BunjangTheme.colors.gray700
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_more_18),
                    contentDescription = null,
                    tint = BunjangTheme.colors.gray700,
                    modifier = Modifier.size(15.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.padding(horizontal = 16.5.dp),
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            homeKidultList.forEach { item ->
                ProductCard(
                    modifier = Modifier.weight(1f),
                    type = ProductCardType.BIG,
                    imageUrl = item.imageUrl,
                    price = item.price,
                    title = item.title,
                    time = item.time,
                    isLike = item.isLike,
                    likes = item.likes
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeKidultSection() {
    BunjangTheme {
        val homeKidultList = listOf(
            HomeKidultProduct("", 100, "상품명", time = "1일 전", likes = 0),
            HomeKidultProduct("", 100, "상품명", time = "1일 전", likes = 0),
            HomeKidultProduct("", 100, "상품명", time = "1일 전", likes = 0),
            HomeKidultProduct("", 200, "상품명", time = "1일 전", likes = 0)
        )
        HomeKidultSection(
            homeKidultList = homeKidultList
        )
    }
}