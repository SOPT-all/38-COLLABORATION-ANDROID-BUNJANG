package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.core.extension.noRippleClickable
import com.sopt.bunjang.presentation.productdetail.model.ProductSimilarGroup
import com.sopt.bunjang.presentation.productdetail.model.ProductSimilarItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ProductSimilarSection(
    styleGroups: ImmutableList<ProductSimilarGroup>,
    onProductClick: (Long) -> Unit,
    onLikeClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "같은 스타일의 다른 상품",
            style = BunjangTheme.typography.title.title3,
            color = BunjangTheme.colors.black,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "같은 카테고리의 비슷한 상품이에요",
            style = BunjangTheme.typography.body.body4,
            color = BunjangTheme.colors.gray500,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(styleGroups) { group ->
                Column(
                    modifier = Modifier.fillParentMaxWidth(0.85f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        group.tags.forEach { tag ->
                            ProductSimilarHashTagChip(text = tag)
                        }
                    }

                    ProductSimilarBannerCard(
                        title = group.bannerTitle,
                        subtitle = group.bannerSubtitle,
                        imageUrl = group.bannerImageUrl
                    )

                    group.products.take(3).forEach { product ->
                        ProductSimilarItemCard(
                            product = product,
                            onClick = { onProductClick(product.id) },
                            onLikeClick = { onLikeClick(product.id) }
                        )

                        HorizontalDivider(
                            thickness = 1.dp,
                            color = BunjangTheme.colors.gray200,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProductSimilarHashTagChip(text: String) {
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = BunjangTheme.colors.gray200,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(horizontal = 8.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "#",
            color = BunjangTheme.colors.primaryRed,
            style = BunjangTheme.typography.body.body5
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = text,
            color = BunjangTheme.colors.gray700,
            style = BunjangTheme.typography.body.body5
        )
    }
}

@Composable
private fun ProductSimilarBannerCard(
    title: String,
    subtitle: String,
    imageUrl: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(278f / 97f)
            .clip(RoundedCornerShape(5.dp))
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "배너 이미지",
            placeholder = ColorPainter(Color.Gray),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(15.dp)
        ) {
            Text(
                text = title,
                style = BunjangTheme.typography.title.title4,
                color = BunjangTheme.colors.white
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = subtitle,
                style = BunjangTheme.typography.body.body3,
                color = BunjangTheme.colors.gray200
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "전체 보기",
                style = BunjangTheme.typography.label.label1,
                color = BunjangTheme.colors.white
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_more_18),
                contentDescription = null,
                tint = BunjangTheme.colors.white,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
private fun ProductSimilarItemCard(
    product: ProductSimilarItem,
    onClick: () -> Unit,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val formattedPrice = "%,d".format(product.price) + "원"

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(84.dp)
            .noRippleClickable(onClick),
        verticalAlignment = Alignment.Bottom
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.title,
            placeholder = ColorPainter(Color.LightGray),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(84.dp)
                .clip(RoundedCornerShape(5.dp))
                .padding(bottom = 1.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = formattedPrice,
                style = BunjangTheme.typography.body.body1_1,
                color = BunjangTheme.colors.gray900
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.title,
                style = BunjangTheme.typography.body.body2_1,
                color = BunjangTheme.colors.gray600
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = if (product.isLike) R.drawable.ic_heart_filled_24 else R.drawable.ic_heart_outlined_24),
                contentDescription = null,
                modifier = Modifier
                    .noRippleClickable(onLikeClick)
                    .padding(vertical = 3.dp, horizontal = 2.dp)
                    .size(24.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "상품 보기",
                    style = BunjangTheme.typography.label.label1,
                    color = BunjangTheme.colors.gray500
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_more_18),
                    contentDescription = null,
                    tint = BunjangTheme.colors.gray500,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSimilarSectionPreview() {
    val dummyGroup1 = ProductSimilarGroup(
        tags = listOf("패션악세서리", "안경", "디자인").toImmutableList(),
        bannerTitle = "이 안경과 비슷한 스타일",
        bannerSubtitle = "디자인을 기준으로 추천해요",
        bannerImageUrl = "",
        products = List(3) {
            ProductSimilarItem(
                id = it.toLong(),
                imageUrl = "",
                price = 150000,
                title = "상품명 $it",
                isLike = it % 2 == 0
            )
        }.toImmutableList()
    )

    val dummyGroup2 = ProductSimilarGroup(
        tags = listOf("뿔테안경", "빈티지").toImmutableList(),
        bannerTitle = "다른 무드의 안경",
        bannerSubtitle = "새로운 스타일을 도전해보세요",
        bannerImageUrl = "",
        products = List(3) {
            ProductSimilarItem(
                id = (it + 3).toLong(),
                imageUrl = "",
                price = 80000,
                title = "상품명 $it"
            )
        }.toImmutableList()
    )

    BunjangTheme {
        ProductSimilarSection(
            styleGroups = listOf(dummyGroup1, dummyGroup2).toImmutableList(),
            onProductClick = {},
            onLikeClick = {}
        )
    }
}