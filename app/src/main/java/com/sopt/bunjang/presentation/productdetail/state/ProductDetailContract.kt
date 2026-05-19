package com.sopt.bunjang.presentation.productdetail.state

import androidx.compose.runtime.Immutable
import com.sopt.bunjang.presentation.productdetail.model.ProductDetailCardUiModel
import com.sopt.bunjang.presentation.productdetail.model.ProductRecommendItem
import com.sopt.bunjang.presentation.productdetail.model.ProductSimilarGroup
import com.sopt.bunjang.presentation.productdetail.model.ProductSimilarItem
import com.sopt.bunjang.presentation.productdetail.model.StoreProductItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
data class ProductDetailUiState(
    val isLike: Boolean = false,
    val isFollowing: Boolean = false,
    val productDetail: ProductDetailCardUiModel? = null,
    val storeProducts: ImmutableList<StoreProductItem> = persistentListOf(),
    val userName: String = "",
    val recommendProducts: ImmutableList<ProductRecommendItem> = persistentListOf(),
    val similarProducts: ImmutableList<ProductSimilarGroup> = persistentListOf(),
) {
    companion object {
        val dummy = ProductDetailUiState(
            isLike = false,
            isFollowing = false,
            productDetail = ProductDetailCardUiModel(
                id = 1,
                imageUrls = persistentListOf(
                    "https://picsum.photos/id/1/200/300",
                    "https://picsum.photos/id/2/200/300"
                ),
                price = 210000,
                title = "이펙터 코러스 GLCY",
                time = "4일 전",
                views = 148,
                likes = 7,
                comments = 0
            ),
            storeProducts = persistentListOf(
                StoreProductItem(
                    id = 1,
                    imageUrl = "https://picsum.photos/id/3/200/300",
                    title = "상품명",
                    price = 100000,
                    likes = 0
                ),
                StoreProductItem(
                    id = 2,
                    imageUrl = "https://picsum.photos/id/4/200/300",
                    title = "상품명",
                    price = 100000,
                    likes = 0
                ),
                StoreProductItem(
                    id = 3,
                    imageUrl = "https://picsum.photos/id/5/200/300",
                    title = "상품명",
                    price = 100000,
                    likes = 0
                ),
                StoreProductItem(
                    id = 4,
                    imageUrl = "https://picsum.photos/id/6/200/300",
                    title = "상품명",
                    price = 100000,
                    likes = 0
                ),
            ),
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