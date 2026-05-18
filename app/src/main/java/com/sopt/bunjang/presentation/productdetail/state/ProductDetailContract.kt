package com.sopt.bunjang.presentation.productdetail.state

import androidx.compose.runtime.Immutable

@Immutable
data class ProductDetailUiState(
    val isLike: Boolean = false
)

sealed interface ProductDetailSideEffect {
    data object NavigateUp : ProductDetailSideEffect
    data object NavigateToHome : ProductDetailSideEffect
    data object NavigateToPurchase : ProductDetailSideEffect
}