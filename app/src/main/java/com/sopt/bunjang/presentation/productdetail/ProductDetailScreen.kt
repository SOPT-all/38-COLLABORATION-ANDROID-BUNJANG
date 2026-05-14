package com.sopt.bunjang.presentation.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.component.topbar.BunjangTopBar
import com.sopt.bunjang.core.designsystem.component.topbar.TopBarIconButton
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProductDetailRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToPurchase: () -> Unit,
    viewModel: ProductDetailViewModel = viewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { effect ->
            when (effect) {
                is ProductDetailSideEffect.NavigateUp -> navigateUp()
                is ProductDetailSideEffect.NavigateToHome -> navigateToHome()
                is ProductDetailSideEffect.NavigateToPurchase -> navigateToPurchase()
            }
        }
    }

    ProductDetailScreen(
        paddingValues = paddingValues,
        onBackIconClick = viewModel::onBackIconClick,
        onHomeIconClick = viewModel::onHomeIconClick,
        onPurchaseIconClick = viewModel::onPurchaseIconClick
    )
}

@Composable
private fun ProductDetailScreen(
    paddingValues: PaddingValues,
    onBackIconClick: () -> Unit,
    onHomeIconClick: () -> Unit,
    onPurchaseIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        BunjangTopBar(
            leftContent = {
                TopBarIconButton(
                    iconRes = R.drawable.ic_top_bar_back,
                    onClick = onBackIconClick
                )
            },
            rightContent = {
                TopBarIconButton(
                    iconRes = R.drawable.ic_top_bar_home,
                    onClick = onHomeIconClick
                )
                TopBarIconButton(
                    iconRes = R.drawable.ic_top_bar_search,
                    // Todo: 하단 구매하기 버튼 구현 후, 버튼 클릭 시 동작으로 이동 필요
                    onClick = onPurchaseIconClick
                )
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
            paddingValues = PaddingValues(),
            onBackIconClick = {},
            onHomeIconClick = {},
            onPurchaseIconClick = {}
        )
    }
}