package com.sopt.bunjang.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

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
            .fillMaxSize()
    ) {
        AsyncImage(
            model = state.imageUrl,
            contentDescription = state.title,
            modifier = Modifier
                .fillMaxSize()
                .height(125.dp)
        )
        Text(
            // 상품명
            text = state.title,
            /*  style = BunjangTheme.typography.body.m14,
              color = BunjangTheme.colors.black */
        )
        Text(
            // 가격
            text = state.formattedPrice,
            /*  style = BunjangTheme.typography.title.b16,
              color = BunjangTheme.colors.black */
        )
    }
}