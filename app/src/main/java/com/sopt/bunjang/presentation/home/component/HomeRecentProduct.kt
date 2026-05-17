package com.sopt.bunjang.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
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

data class HomeSimilarProduct(
    val imageUrl: String,
    val price: Int,
    val title: String,
    val isAd: Boolean = false
)

val recentCategory = listOf("안경", "선글라스", "잡화", "의류", "모자", "티켓")

@Composable
fun HomeRecentProduct(
    modifier: Modifier = Modifier,
    homeRecentProductList: List<HomeSimilarProduct>
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 17.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "최근 본 상품과 비슷한 상품",
                style = BunjangTheme.typography.title.title3,
                color = BunjangTheme.colors.black
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "더보기",
                    style = BunjangTheme.typography.label.label1,
                    color = BunjangTheme.colors.gray700
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_more_18),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(15.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 17.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(recentCategory) { index, category ->
                Box(
                    modifier = Modifier
                        .border(
                            1.dp,
                            if (index == 0) BunjangTheme.colors.primaryRed else BunjangTheme.colors.gray400,
                            RoundedCornerShape(20.dp)
                        )
                        .background(
                            if (index == 0) BunjangTheme.colors.lightRed else BunjangTheme.colors.white,
                            RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = category,
                        color = if (index == 0) BunjangTheme.colors.primaryRed else BunjangTheme.colors.gray400,
                        style = BunjangTheme.typography.body.body2_1
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 17.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(homeRecentProductList) { item ->
                ProductCard(
                    modifier = Modifier.width(102.dp),
                    type = ProductCardType.SMALL,
                    imageUrl = item.imageUrl,
                    price = item.price,
                    title = item.title,
                    isAd = item.isAd
                )
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_slider_left),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .height(3.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeRecentProduct() {
    BunjangTheme {
        val homeRecentProductList = listOf(
            HomeSimilarProduct("", 100, "상품명", isAd = true),
            HomeSimilarProduct("", 100, "상품명"),
            HomeSimilarProduct("", 100, "상품명"),
            HomeSimilarProduct("", 200, "상품명")
        )
        HomeRecentProduct(
            homeRecentProductList = homeRecentProductList
        )
    }
}