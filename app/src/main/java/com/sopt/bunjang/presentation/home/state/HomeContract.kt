package com.sopt.bunjang.presentation.home.state

sealed interface HomeSideEffect {
    data class NavigateToProductDetail(val id: Long) : HomeSideEffect
}