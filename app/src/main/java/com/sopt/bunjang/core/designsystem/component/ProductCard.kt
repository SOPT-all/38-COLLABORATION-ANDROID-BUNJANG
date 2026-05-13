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

@Composable
fun BigProductCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    price: Int,
    title: String,
    time: String? = null,
    isLike: Boolean = false,
    likes: Int? = null,
    onCardClick: () -> Unit = {},
    onLikeClick: () -> Unit = {}
) {
    val formattedPrice = "%,d".format(price) + "원"

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(BunjangTheme.colors.white)
            .noRippleClickable { onCardClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(160f / 194f)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                placeholder = ColorPainter(Color.LightGray),  // 아이콘이랑 구분되게 하려고
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(160f / 194f)
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
            style = BunjangTheme.typography.title.title5,
            color = BunjangTheme.colors.gray900
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            // 상품명
            text = title,
            style = BunjangTheme.typography.body.body2,
            color = BunjangTheme.colors.gray700
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (time != null) {
                Text(
                    text = time,
                    style = BunjangTheme.typography.label.label2,
                    color = BunjangTheme.colors.gray400,
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp, bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            if (likes != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home_fillheart),
                        contentDescription = "like",
                        tint = BunjangTheme.colors.gray200,
                        modifier = Modifier
                            .size(12.dp)
                            .padding(end = 1.dp)
                            .noRippleClickable { onLikeClick() }
                    )

                    Text(
                        text = likes.toString(),
                        style = BunjangTheme.typography.label.label2,
                        color = BunjangTheme.colors.gray500,
                        modifier = Modifier.padding(end = 2.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SmallProductCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    price: Int,
    title: String,
    onCardClick: () -> Unit = {},
    onLikeClick: () -> Unit = {}
) {
    val formattedPrice = "%,d".format(price) + "원"

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(BunjangTheme.colors.white)
            .noRippleClickable { onCardClick() }
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(102f / 125f)
        )
        {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                placeholder = ColorPainter(Color.LightGray),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(102f / 125f)
                    .clip(RoundedCornerShape(4.dp))
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_heart_outlined_24),
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
            style = BunjangTheme.typography.body.body1_1,
            color = BunjangTheme.colors.gray900
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            // 상품명
            text = title,
            style = BunjangTheme.typography.label.label1,
            color = BunjangTheme.colors.gray800
        )
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
            BigProductCard(
                imageUrl = "",
                price = 690000,
                title = "상품명",
                time = "1일 전",
                likes = 0,
                modifier = Modifier.width(160.dp)

            )
            SmallProductCard(
                imageUrl = "",
                price = 100,
                title = "상품명",
                modifier = Modifier.width(102.dp)
            )
        }
    }
}