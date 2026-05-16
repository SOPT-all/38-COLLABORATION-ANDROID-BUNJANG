package com.sopt.bunjang.presentation.productdetail.state

import androidx.compose.runtime.Immutable
import com.sopt.bunjang.presentation.productdetail.model.ProductRecommendItem
import com.sopt.bunjang.presentation.productdetail.model.ProductSimilarGroup
import com.sopt.bunjang.presentation.productdetail.model.ProductSimilarItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
data class ProductDetailUiState(
    val userName: String = "",
    val recommendProducts: ImmutableList<ProductRecommendItem> = persistentListOf(),
    val similarProducts: ImmutableList<ProductSimilarGroup> = persistentListOf(),
) {
    companion object {
        val dummy = ProductDetailUiState(
            userName = "혁줌마",
            recommendProducts = List(6) {
                ProductRecommendItem(
                    id = it.toLong(),
                    imageUrl = "https://picsum.photos/200",
                    price = 690000,
                    title = "상품명 $it",
                    time = "1일 전",
                    likes = it + 10,
                    isLike = false
                )
            }.toImmutableList(),
            similarProducts = listOf(
                ProductSimilarGroup(
                    tags = listOf("패션악세서리", "안경", "디자인").toImmutableList(),
                    bannerTitle = "이 안경과 비슷한 스타일",
                    bannerSubtitle = "디자인을 기준으로 추천해요",
                    bannerImageUrl = "https://picsum.photos/200",
                    products = List(3) {
                        ProductSimilarItem(
                            id = (it + 10).toLong(),
                            imageUrl = "https://picsum.photos/200",
                            price = 150000,
                            title = "비슷한 상품명 $it"
                        )
                    }.toImmutableList()
                ),

                ProductSimilarGroup(
                    tags = listOf("패션악세서리", "안경", "디자인").toImmutableList(),
                    bannerTitle = "이 안경과 비슷한 스타일",
                    bannerSubtitle = "디자인을 기준으로 추천해요",
                    bannerImageUrl = "https://picsum.photos/200",
                    products = List(3) {
                        ProductSimilarItem(
                            id = (it + 20).toLong(),
                            imageUrl = "https://picsum.photos/200",
                            price = 150000,
                            title = "비슷한 상품명 $it"
                        )
                    }.toImmutableList()
                )
            ).toImmutableList()
        )
    }
}

sealed interface ProductDetailSideEffect {
    data object NavigateUp : ProductDetailSideEffect
    data object NavigateToHome : ProductDetailSideEffect
    data object NavigateToPurchase : ProductDetailSideEffect
    data class NavigateToProductDetail(val id: Long) : ProductDetailSideEffect
}