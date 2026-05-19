package com.sopt.bunjang.presentation.productdetail.state

import androidx.compose.runtime.Immutable
import com.sopt.bunjang.presentation.productdetail.ProductDetailViewModel

@Immutable
data class ProductDetailUiState(
    val productDetail: ProductDetailViewModel? = null,
    val isLike: Boolean = false,
    val isFollowing: Boolean = false
)

sealed interface ProductDetailSideEffect {
    data object NavigateUp : ProductDetailSideEffect
    data object NavigateToHome : ProductDetailSideEffect
    data object NavigateToPurchase : ProductDetailSideEffect
}