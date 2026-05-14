package com.sopt.bunjang.presentation.productdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.core.extension.noRippleClickable

@Composable
fun ChatButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    backgroundColor: Color = BunjangTheme.colors.white
) {
    Row(
        modifier = modifier
            .size(48.dp)
            .clip(shape = RoundedCornerShape(6.dp))
            .border(1.dp, BunjangTheme.colors.gray200, RoundedCornerShape(6.dp))
            .background(color = backgroundColor)
            .noRippleClickable(onClick)
            .padding(horizontal = 12.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_detail_page_chat),
            contentDescription = "chat",
            tint = BunjangTheme.colors.black,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
private fun ChatButtonPreview() {
    BunjangTheme {
        ChatButton()
    }
}
