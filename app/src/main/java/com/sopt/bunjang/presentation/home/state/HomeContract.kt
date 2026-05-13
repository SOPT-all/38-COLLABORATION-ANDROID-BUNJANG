package com.sopt.bunjang.presentation.home.state

sealed interface HomeSideEffect {
    data object NavigateToProductDetail : HomeSideEffect
}