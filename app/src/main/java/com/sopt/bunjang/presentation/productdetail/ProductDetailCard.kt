package com.sopt.bunjang.presentation.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
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
    }
}
