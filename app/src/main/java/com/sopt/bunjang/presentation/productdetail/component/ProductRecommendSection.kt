package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.core.designsystem.component.ProductCard
import com.sopt.bunjang.core.designsystem.component.ProductCardType
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.presentation.productdetail.model.ProductRecommendItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ProductRecommendSection(
    userName: String,
    products: ImmutableList<ProductRecommendItem>,
    onProductClick: (Long) -> Unit,
    onLikeClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    onViewAllClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        val titleText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = BunjangTheme.colors.primaryRed)) {
                append(userName)
            }
            append("님이 좋아할 만한 상품")
        }

        Text(
            text = titleText,
            style = BunjangTheme.typography.title.title3,
            color = BunjangTheme.colors.black
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "관심 상품을 바탕으로 추천해요",
            style = BunjangTheme.typography.body.body4,
            color = BunjangTheme.colors.gray500
        )

        Spacer(modifier = Modifier.height(16.dp))

        products.chunked(2).forEach { rowProducts ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowProducts.forEach { product ->
                    ProductCard(
                        type = ProductCardType.BIG,
                        imageUrl = product.imageUrl,
                        price = product.price,
                        title = product.title,
                        time = product.time,
                        likes = product.likes,
                        isLike = product.isLike,
                        isAd = product.isAd,
                        onCardClick = { onProductClick(product.id) },
                        onLikeClick = { onLikeClick(product.id) },
                        modifier = Modifier.weight(1f)
                    )
                }

                if (rowProducts.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        ViewAllButton(
            text = "${userName}님 취향 상품 357개",
            onClick = onViewAllClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductRecommendSectionPreview() {
    val dummyProducts = List(5) {
        ProductRecommendItem(
            id = it.toLong(),
            imageUrl = "",
            price = 690000,
            title = "상품명 $it",
            time = "1일 전",
            likes = 0,
            isLike = false
        )
    }

    BunjangTheme {
        ProductRecommendSection(
            userName = "혁줌마",
            products = dummyProducts.toImmutableList(),
            onProductClick = {},
            onLikeClick = {},
            onViewAllClick = {}
        )
    }
}