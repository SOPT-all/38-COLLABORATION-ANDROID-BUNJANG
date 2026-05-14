package com.sopt.bunjang.presentation.productdetail.state

sealed interface ProductDetailSideEffect {
    data object NavigateUp : ProductDetailSideEffect
    data object NavigateToHome : ProductDetailSideEffect
    data object NavigateToPurchase : ProductDetailSideEffect
}