package com.sopt.bunjang.presentation.home.state

import androidx.compose.runtime.Immutable
import com.sopt.bunjang.presentation.home.model.HomeGlassesProduct
import com.sopt.bunjang.presentation.home.model.HomeKidultProduct
import com.sopt.bunjang.presentation.home.model.HomeSimilarProduct
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

sealed interface HomeSideEffect {
    data object NavigateToProductDetail : HomeSideEffect
}

@Immutable
data class HomeUiState(
    val glassesProducts: ImmutableList<HomeGlassesProduct> = persistentListOf(),
    val kidultProducts: ImmutableList<HomeKidultProduct> = persistentListOf(),
    val similarProducts: ImmutableList<HomeSimilarProduct> = persistentListOf(),
    val userName: String = "혁준마님",
    val productCount: Int = 357
) {
    companion object {
        val dummy = HomeUiState(
            glassesProducts = persistentListOf(
                HomeGlassesProduct("https://picsum.photos/200/300", 100, "상품명", time = "1일 전", likes = 0, isAd = true),
                HomeGlassesProduct("https://picsum.photos/200/300", 100, "상품명", time = "1일 전", likes = 0),
                HomeGlassesProduct("https://picsum.photos/200/300", 100, "상품명", time = "1일 전", likes = 0),
                HomeGlassesProduct("https://picsum.photos/200/300", 200, "상품명", time = "1일 전", likes = 0)
            ),
            kidultProducts = persistentListOf(
                HomeKidultProduct("https://picsum.photos/200/300", 100, "상품명", time = "1일 전", likes = 0),
                HomeKidultProduct("https://picsum.photos/200/300", 100, "상품명", time = "1일 전", likes = 0),
                HomeKidultProduct("https://picsum.photos/200/300", 100, "상품명", time = "1일 전", likes = 0),
                HomeKidultProduct("https://picsum.photos/200/300", 200, "상품명", time = "1일 전", likes = 0)
            ),
            similarProducts = persistentListOf(
                HomeSimilarProduct("https://picsum.photos/200/300", 100, "상품명", isAd = true),
                HomeSimilarProduct("https://picsum.photos/200/300", 100, "상품명"),
                HomeSimilarProduct("https://picsum.photos/200/300", 100, "상품명"),
                HomeSimilarProduct("https://picsum.photos/200/300", 200, "상품명")
            )
        )
    }
}