package com.sopt.bunjang.presentation.purchase.component

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.sopt.bunjang.core.extension.noRippleClickable
import com.sopt.bunjang.presentation.purchase.model.PurchaseProductItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun PurchaseRecommendSection(
    products: ImmutableList<PurchaseProductItem>,
    onProductClick: (PurchaseProductItem) -> Unit,
    onLikeClick: (PurchaseProductItem) -> Unit,
    modifier: Modifier = Modifier,
    onMoreClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
                .padding(end = 3.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "이 상품과 함께 많이 구매한 상품",
                style = BunjangTheme.typography.title.title3,
                color = BunjangTheme.colors.black
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.noRippleClickable { onMoreClick() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "더보기",
                    style = BunjangTheme.typography.body.body2,
                    color = BunjangTheme.colors.gray700
                )
                Icon(
                    painter = painterResource(R.drawable.ic_more_18),
                    contentDescription = null,
                    tint = BunjangTheme.colors.gray700,
                    modifier = Modifier.size(15.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp)
                .background(
                    color = BunjangTheme.colors.lightRed,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "많은 사람들이 함께 구매한 상품이에요",
                style = BunjangTheme.typography.body.body4_1,
                color = BunjangTheme.colors.primaryRed
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 21.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(products) { product ->
                ProductCard(
                    modifier = Modifier.fillParentMaxWidth(0.28f),
                    type = ProductCardType.SMALL,
                    imageUrl = product.imageUrl,
                    price = product.price,
                    title = product.title,
                    onCardClick = { onProductClick(product) },
                    isLike = product.isLike,
                    isAd = product.isAd,
                    onLikeClick = { onLikeClick(product) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PurchaseRecommendSectionPreview() {
    BunjangTheme {
        PurchaseRecommendSection(
            products = listOf(
                PurchaseProductItem(
                    id = 1,
                    imageUrl = "https://picsum.photos/200",
                    price = 10000,
                    title = "상품명",
                    isLike = false,
                    isAd = true
                ),
                PurchaseProductItem(
                    id = 2,
                    imageUrl = "https://picsum.photos/200",
                    price = 10000,
                    title = "상품명",
                    isLike = false
                )
            ).toImmutableList(),
            onProductClick = {},
            onLikeClick = {},
            onMoreClick = {}
        )
    }
}