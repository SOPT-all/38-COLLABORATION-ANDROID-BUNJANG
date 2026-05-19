package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.core.extension.noRippleClickable

enum class ShareAndLikeType { SHARE, LIKE }

@Composable
fun ShareAndLikeButton(
    type: ShareAndLikeType,
    modifier: Modifier = Modifier,
    isLike: Boolean = false,
    onShareClick: () -> Unit = {},
    onLikeClick: () -> Unit = {}
) {
    val label = when (type) {
        ShareAndLikeType.SHARE -> "공유"
        ShareAndLikeType.LIKE -> "찜"
    }
    val icon = when (type) {
        ShareAndLikeType.SHARE -> R.drawable.ic_detail_page_share
        ShareAndLikeType.LIKE -> if (isLike) R.drawable.ic_heart_filled_24 else R.drawable.ic_heart_outlined_gray_24
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(BunjangTheme.colors.white)
            .noRippleClickable {
                when (type) {
                    ShareAndLikeType.SHARE -> onShareClick()
                    ShareAndLikeType.LIKE -> {
                        onLikeClick()
                    }
                }
            }
            .padding(top = 14.dp, bottom = 11.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            tint = if (isLike) BunjangTheme.colors.primaryRed else BunjangTheme.colors.gray700,
            modifier = Modifier
                .size(24.dp)
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(
            text = label,
            color = BunjangTheme.colors.gray700,
            style = BunjangTheme.typography.body.body2
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShareAndWishButtonPreview() {
    BunjangTheme {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ShareAndLikeButton(
                type = ShareAndLikeType.SHARE,
                modifier = Modifier.weight(1f)
            )

            VerticalDivider(
                color = BunjangTheme.colors.gray200,
                modifier = Modifier.height(33.dp),
                thickness = 1.dp
            )

            ShareAndLikeButton(
                type = ShareAndLikeType.LIKE,
                modifier = Modifier.weight(1f)
            )
        }
    }
}