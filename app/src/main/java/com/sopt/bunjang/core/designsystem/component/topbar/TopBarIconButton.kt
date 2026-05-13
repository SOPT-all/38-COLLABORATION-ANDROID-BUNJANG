package com.sopt.bunjang.core.designsystem.component.topbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.core.extension.noRippleClickable

@Composable
fun TopBarIconButton(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    onClick: () -> Unit = {}
) {
    Icon(
        painter = painterResource(iconRes),
        contentDescription = contentDescription,
        modifier = modifier
            .size(24.dp)
            .noRippleClickable { onClick() }
    )
}