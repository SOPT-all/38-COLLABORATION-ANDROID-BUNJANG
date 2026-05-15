package com.sopt.bunjang.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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

enum class ProductCardType { BIG, SMALL }

@Composable
fun ProductCard(
    type: ProductCardType,
    imageUrl: String,
    price: Int,
    title: String,
    modifier: Modifier = Modifier,
    time: String? = null,
    isLike: Boolean = false,
    likes: Int? = null,
    onCardClick: () -> Unit = {},
    onLikeClick: () -> Unit = {}
) {
    val formattedPrice = "%,d".format(price) + "원"
    val imageRatio = when (type) {
        ProductCardType.BIG -> 160f / 194f
        ProductCardType.SMALL -> 102f / 125f
    }
    val priceStyle = when (type) {
        ProductCardType.BIG -> BunjangTheme.typography.title.title5
        ProductCardType.SMALL -> BunjangTheme.typography.body.body1_1
    }
    val titleStyle = when (type) {
        ProductCardType.BIG -> BunjangTheme.typography.body.body2
        ProductCardType.SMALL -> BunjangTheme.typography.label.label1
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(BunjangTheme.colors.white)
            .noRippleClickable { onCardClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(imageRatio)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                placeholder = ColorPainter(Color.LightGray),  // 아이콘이랑 구분되게 하려고
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(imageRatio)
                    .clip(RoundedCornerShape(4.dp))
            )

            Icon(
                painter = painterResource(
                    id = if (isLike) R.drawable.ic_home_fillheart else R.drawable.ic_heart_outlined_24
                ),
                contentDescription = "like",
                tint = BunjangTheme.colors.white,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(24.dp)
                    .noRippleClickable { onLikeClick() }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            // 가격
            text = formattedPrice,
            style = priceStyle,
            color = BunjangTheme.colors.gray900
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            // 상품명
            text = title,
            style = titleStyle,
            color = BunjangTheme.colors.gray700
        )

        if (type == ProductCardType.BIG) {
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 시간 표시: let 활용
                time?.let {
                    Text(
                        text = it,
                        style = BunjangTheme.typography.label.label2,
                        color = BunjangTheme.colors.gray400,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                // 좋아요 표시: let 활용
                likes?.let { count ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home_fillheart),
                            contentDescription = "like count",
                            tint = BunjangTheme.colors.gray200,
                            modifier = Modifier
                                .size(12.dp)
                        )
                        Spacer(modifier = Modifier.width(1.dp))
                        Text(
                            text = count.toString(),
                            style = BunjangTheme.typography.label.label2,
                            color = BunjangTheme.colors.gray500,
                            modifier = Modifier.padding(end = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    BunjangTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            ProductCard(
                type = ProductCardType.BIG,
                imageUrl = "",
                price = 690000,
                title = "상품명",
                time = "1일 전",
                likes = 0,
                modifier = Modifier.width(160.dp)
            )
            ProductCard(
                type = ProductCardType.SMALL,
                imageUrl = "",
                price = 100,
                title = "상품명",
                modifier = Modifier.width(102.dp)
            )
        }
    }
}