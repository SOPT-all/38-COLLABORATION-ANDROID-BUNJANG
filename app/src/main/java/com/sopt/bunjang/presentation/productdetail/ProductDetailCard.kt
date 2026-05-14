package com.sopt.bunjang.presentation.productdetail

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

@Composable
fun ProductDetailCard(
    imageUrl: String,
    title: String,
    price: Int,
    modifier: Modifier = Modifier,
    isLike: Boolean = false,
    time: String? = null,
    views: Int? = null,
    likes: Int? = null,
    comments: Int? = null,
    onLikeClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(BunjangTheme.colors.white)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(361f / 360f)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                placeholder = ColorPainter(Color.LightGray),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(361f / 360f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 19.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    style = BunjangTheme.typography.title.title4
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "%,d".format(price) + "원",
                    style = BunjangTheme.typography.title.title1
                )
            }

            Icon(
                painter = painterResource(
                    id = if (isLike) R.drawable.ic_heart_filled_39 else R.drawable.ic_heart_outlined_39
                ),
                contentDescription = "like",
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(vertical = 5.5.dp)
                    .size(39.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailCardPreview() {
    BunjangTheme {
        ProductDetailCard(
            imageUrl = "",
            price = 210000,
            title = "이펙터 코러스 GLCY"
        )
    }
}

