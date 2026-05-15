package com.sopt.bunjang.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.component.ProductCard
import com.sopt.bunjang.core.designsystem.component.ProductCardType
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

data class HomeProduct(
    val imageUrl: String,
    val price: Int,
    val title: String,
    val time: String? = null,
    val isLike: Boolean = false,
    val likes: Int? = null
)

val homeProductList = listOf(
    HomeProduct("", 100, "상품명", time = "1일 전", likes = 0),
    HomeProduct("", 100, "상품명", time = "1일 전", likes = 0),
    HomeProduct("", 100, "상품명", time = "1일 전", likes = 0),
    HomeProduct("", 200, "상품명", time = "1일 전", likes = 0),
)

@Composable
fun HomeGlassesSection(
    modifier: Modifier = Modifier,
    homeProductList: List<HomeProduct>) {
    Column(modifier = modifier) {
        Row(modifier = modifier.padding(horizontal = 17.dp)) {
            Text(
                text = "안경",
                style = BunjangTheme.typography.title.title3,
                color = BunjangTheme.colors.primaryRed
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "카테고리의 추천상품",
                style = BunjangTheme.typography.title.title3,
                color = BunjangTheme.colors.black
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = modifier.padding(horizontal = 17.dp),
            text = "최근 본 카테고리의 상품 기반으로 추천해줘요",
            style = BunjangTheme.typography.body.body4,
            color = BunjangTheme.colors.gray500
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.padding(horizontal = 16.5.dp),
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            homeProductList.forEach { item ->
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
        Row(
            modifier = Modifier
                .padding(horizontal = 18.5.dp, vertical = 16.dp)
                .height(38.dp)
                .fillMaxWidth()
                .border(1.dp, BunjangTheme.colors.gray200, RoundedCornerShape(6.dp))
                .background(color = BunjangTheme.colors.white),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "혁준마님 취향 상품 357개 ",
                style = BunjangTheme.typography.body.body2,
                color = BunjangTheme.colors.black
            )
            Text(
                text = "더 보기",
                style = BunjangTheme.typography.body.body2,
                color = BunjangTheme.colors.primaryRed
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_more_18),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeGlassesSection() {
    BunjangTheme {
        HomeGlassesSection(
            homeProductList = homeProductList
        )
    }
}