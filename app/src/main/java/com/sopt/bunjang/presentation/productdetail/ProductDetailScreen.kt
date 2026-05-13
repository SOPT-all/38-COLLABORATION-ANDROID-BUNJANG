package com.sopt.bunjang.presentation.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.component.topbar.BunjangTopBar
import com.sopt.bunjang.core.designsystem.component.topbar.TopBarIconButton
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.presentation.home.component.HomeLogo

@Composable
fun ProductDetailRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToPurChase: () -> Unit
) {
    ProductDetailScreen(
        paddingValues = paddingValues,
    )
}

@Composable
private fun ProductDetailScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        BunjangTopBar(
            leftContent = { HomeLogo() },
            rightContent = {
                TopBarIconButton(iconRes = R.drawable.ic_top_bar_home)
                TopBarIconButton(iconRes = R.drawable.ic_top_bar_search)
                TopBarIconButton(iconRes = R.drawable.ic_top_bar_cart)
            }
        )

    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    BunjangTheme {
        ProductDetailScreen(
            paddingValues = PaddingValues()
        )
    }
}