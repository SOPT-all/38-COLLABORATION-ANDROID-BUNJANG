package com.sopt.bunjang.presentation.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.component.topbar.BunjangTopBar
import com.sopt.bunjang.core.designsystem.component.topbar.TopBarIconButton
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.presentation.productdetail.component.CartButton
import com.sopt.bunjang.presentation.productdetail.component.ChatButton
import com.sopt.bunjang.presentation.productdetail.component.OrderButton
import com.sopt.bunjang.presentation.productdetail.component.ProductRecommendSection
import com.sopt.bunjang.presentation.productdetail.component.ProductSimilarSection
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailSideEffect
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailUiState

@Composable
fun ProductDetailRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToPurchase: () -> Unit,
    navigateToProductDetail: (Long) -> Unit,
    viewModel: ProductDetailViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is ProductDetailSideEffect.NavigateUp -> navigateUp()
                is ProductDetailSideEffect.NavigateToHome -> navigateToHome()
                is ProductDetailSideEffect.NavigateToPurchase -> navigateToPurchase()
                is ProductDetailSideEffect.NavigateToProductDetail -> navigateToProductDetail(sideEffect.id)
            }
        }
    }

    ProductDetailScreen(
        paddingValues = paddingValues,
        uiState = uiState,
        onBackIconClick = viewModel::onBackIconClick,
        onHomeIconClick = viewModel::onHomeIconClick,
        onPurchaseIconClick = viewModel::onPurchaseIconClick,
        onProductClick = viewModel::onProductClick,
        onLikeClick = viewModel::onLikeClick,
    )
}

@Composable
private fun ProductDetailScreen(
    paddingValues: PaddingValues,
    uiState: ProductDetailUiState,
    onBackIconClick: () -> Unit,
    onHomeIconClick: () -> Unit,
    onPurchaseIconClick: () -> Unit,
    onProductClick: (Long) -> Unit,
    onLikeClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = BunjangTheme.colors.white),
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
                TopBarIconButton(iconRes = R.drawable.ic_top_bar_search,)
                TopBarIconButton(iconRes = R.drawable.ic_top_bar_cart)
            }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            // 지영이 파트 (상단 상품 상세 정보 등)

            item {
                HorizontalDivider(
                    thickness = 4.dp,
                    color = BunjangTheme.colors.gray100,
                    modifier = Modifier.padding(vertical = 24.dp)
                )
            }

            item {
                ProductRecommendSection(
                    userName = uiState.userName,
                    products = uiState.recommendProducts,
                    onProductClick = onProductClick,
                    onLikeClick = onLikeClick,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            item {
                ProductSimilarSection(
                    styleGroups = uiState.similarProducts,
                    onProductClick = onProductClick,
                    onLikeClick = onLikeClick,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = BunjangTheme.colors.gray100
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 19.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
            ) {
                ChatButton()
                CartButton(text = "장바구니")
                OrderButton(
                    text = "구매하기",
                    onClick = onPurchaseIconClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    BunjangTheme {
        ProductDetailScreen(
            paddingValues = PaddingValues(),
            uiState = ProductDetailUiState.dummy,
            onBackIconClick = {},
            onHomeIconClick = {},
            onPurchaseIconClick = {},
            onProductClick = {},
            onLikeClick = {},
        )
    }
}