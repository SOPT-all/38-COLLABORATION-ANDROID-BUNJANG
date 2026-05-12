package com.sopt.bunjang.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

data class ProductCardState(
    val imageUrl: String,
    val price: Int,
    val title: String,
    val time: String? = null,
    val isFavorite: Boolean = false,
    val favoriteCount: Int? = 0,
) {
    val formattedPrice: String
        get() = "%,d".format(price) + "원"
}

@Composable
fun BigProductCard(
    state: ProductCardState,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .size(width = 160.dp, height = 266.dp)
            .background(BunjangTheme.colors.white)
            .clickable { onCardClick() }
    ) {
        AsyncImage(
            model = state.imageUrl,
            contentDescription = state.title,
            modifier = Modifier
                .size(width = 160.dp, height = 194.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            // 가격
            text = state.formattedPrice,
            style = BunjangTheme.typography.title.title5,
            color = BunjangTheme.colors.gray900
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            // 상품명
            text = state.title,
            style = BunjangTheme.typography.body.body2,
            color = BunjangTheme.colors.gray700
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (state.time != null) {
                Text(
                    text = state.time,
                    style = BunjangTheme.typography.label.label2,
                    color = BunjangTheme.colors.gray400,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
                if (state.favoriteCount != null) {
                    // icon 넣기
                    Text(
                        text = state.favoriteCount.toString(),
                        style = BunjangTheme.typography.label.label2,
                        color = BunjangTheme.colors.gray500,
                        modifier = Modifier
                            .padding(horizontal = 2.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }

@Composable
fun SmallProductCard(
    state: ProductCardState,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(BunjangTheme.colors.white)
            .clickable { onCardClick() }
            .width(102.dp)
    )
    {
        AsyncImage(
            model = state.imageUrl,
            contentDescription = state.title,
            modifier = Modifier
                .height(125.dp)
                .clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            // 가격
            text = state.formattedPrice,
            style = BunjangTheme.typography.body.body1_1,
            color = BunjangTheme.colors.gray900
        )
        Text(
            // 상품명
            text = state.title,
            style = BunjangTheme.typography.label.label1,
            color = BunjangTheme.colors.gray800
        )
        // 아이콘 띄우기
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    BunjangTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            BigProductCard(
                state = ProductCardState(
                    imageUrl = "",
                    price = 690000,
                    title = "상품명",
                    time = "1일 전",
                    favoriteCount = 0
                )
            )
            SmallProductCard(
                state = ProductCardState(
                    imageUrl = "",
                    price = 100,
                    title = "상품명"
                )
            )
        }
    }
}