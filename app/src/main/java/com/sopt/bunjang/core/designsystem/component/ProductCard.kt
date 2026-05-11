package com.sopt.bunjang.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

data class ProductCardState(
    val imageUrl: String,
    val price: Int,
    val title: String,
    val createdAt: String? = null,
    val isFavorite: Boolean = false,
    val favoriteCount: Int? = null,
) {
    val formattedPrice: String
        get() = "%,d".format(price) + "원"
}

@Composable
fun SmallProductCard(
    state: ProductCardState,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .clickable { onCardClick() }
            .width(102.dp)
    ) {
        Box {
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
}