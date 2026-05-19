package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun StoreProductCard(
    imageUrl: String,
    title: String,
    price: Int,
    modifier: Modifier = Modifier,
    likes: Int? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth(),

        ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            placeholder = ColorPainter(Color.LightGray), //프리뷰 확인
            error = ColorPainter(Color.LightGray), //에뮬레이터 확인
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1f)
                .clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = title,
            color = BunjangTheme.colors.gray600,
            style = BunjangTheme.typography.label.label4
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "%,d".format(price) + "원",
            color = BunjangTheme.colors.gray700,
            style = BunjangTheme.typography.label.label1
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            likes?.let { count ->
                Icon(
                    painter = painterResource(id = R.drawable.ic_detail_page_heart),
                    contentDescription = "likes",
                    tint = BunjangTheme.colors.gray300,
                    modifier = Modifier.size(12.dp)
                )

                Spacer(modifier = Modifier.width(1.dp))

                Text(
                    text = count.toString(),
                    style = BunjangTheme.typography.label.label2,
                    color = BunjangTheme.colors.gray300
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreProductCardPreview() {
    BunjangTheme {
        StoreProductCard(
            imageUrl = "",
            title = "상품명",
            price = 100000,
            likes = 0,
            modifier = Modifier.width(102.dp)
        )
    }
}