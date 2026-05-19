package com.sopt.bunjang.presentation.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
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
import com.sopt.bunjang.presentation.productdetail.component.InfoSection
import com.sopt.bunjang.presentation.productdetail.component.ProductDetailCard
import com.sopt.bunjang.presentation.productdetail.component.ProductDetailTabRow
import com.sopt.bunjang.presentation.productdetail.component.SellerInfoSection
import com.sopt.bunjang.presentation.productdetail.component.ShareAndLikeButton
import com.sopt.bunjang.presentation.productdetail.component.ShareAndLikeType
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailSideEffect
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailUiState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProductDetailRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToPurchase: () -> Unit,
    viewModel: ProductDetailViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

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
        uiState = uiState,
        onBackIconClick = viewModel::onBackIconClick,
        onHomeIconClick = viewModel::onHomeIconClick,
        onPurchaseIconClick = viewModel::onPurchaseIconClick,
        onLikeClick = viewModel::onLikeClick,
        onFollowClick = viewModel::onFollowClick
    )
}

@Composable
private fun ProductDetailScreen(
    paddingValues: PaddingValues,
    uiState: ProductDetailUiState,
    onBackIconClick: () -> Unit,
    onHomeIconClick: () -> Unit,
    onPurchaseIconClick: () -> Unit,
    onLikeClick: () -> Unit,
    onFollowClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BunjangTheme.colors.white)
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

        Column(
            modifier = modifier.verticalScroll(rememberScrollState())
        ) {
            uiState.productDetail?.let { productDetail ->
                ProductDetailCard(
                    uiModel = productDetail,
                    isLike = uiState.isLike,
                    onLikeClick = onLikeClick,
                )
            }

            HorizontalDivider(
                thickness = 1.dp,
                color = BunjangTheme.colors.gray100
            )

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
                    isLike = uiState.isLike,
                    onLikeClick = onLikeClick,
                    modifier = Modifier.weight(1f)
                )
            }

            HorizontalDivider(
                thickness = 4.dp,
                color = BunjangTheme.colors.gray100
            )

            ProductDetailTabRow()

            Spacer(modifier = Modifier.height(30.dp))

            InfoSection(
                categories = listOf("패션 액세서리", "안경/선글라스", "안경").toImmutableList(),
                condition = "사용감 적음",
                quantity = 1,
                description = "이펙터 코러스 GLCY컬러 판매합니다\n니콘 변색렌즈 장착되어있습니다",
                deliveryFee = 4000
            )

            SellerInfoSection(
                storeName = "Zufall",
                rating = 5.0,
                reviewCount = 15,
                transactionCount = 26,
                isFollowing = uiState.isFollowing,
                onFollowClick = onFollowClick,
                products = uiState.storeProducts
            )
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
            onLikeClick = {},
            onFollowClick = {}
        )
    }
}