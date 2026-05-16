package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.core.extension.noRippleClickable

@Composable
fun FollowButton(
    isFollowing: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(
                width = if (isFollowing) 1.dp else 0.dp,
                color = if (isFollowing) BunjangTheme.colors.gray200 else Color.Transparent,
                shape = RoundedCornerShape(3.dp)
            )
            .background(
                color = if (isFollowing) BunjangTheme.colors.white else BunjangTheme.colors.lightRed,
                shape = RoundedCornerShape(3.dp)
            )
            .noRippleClickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isFollowing) "팔로잉" else "팔로우",
                color = if (isFollowing) BunjangTheme.colors.gray900 else BunjangTheme.colors.primaryRed,
                style = BunjangTheme.typography.body.body2
            )
            if (isFollowing) {

                Spacer(modifier = Modifier.width(4.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_detail_page_check),
                    contentDescription = null,
                    tint = BunjangTheme.colors.gray900,
                    modifier = Modifier.size(12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FollowButtonPreview() {
    BunjangTheme {
        var isFollowing by remember { mutableStateOf(false) }
        FollowButton(
            isFollowing = isFollowing,
            onClick = { isFollowing = !isFollowing }
        )
    }
}