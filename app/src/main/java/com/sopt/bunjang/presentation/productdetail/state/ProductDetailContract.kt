package com.sopt.bunjang.presentation.productdetail.state

import androidx.compose.runtime.Immutable
import com.sopt.bunjang.presentation.productdetail.model.ProductDetailCardUiModel
import com.sopt.bunjang.presentation.productdetail.model.StoreProductItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ProductDetailUiState(
    val isLike: Boolean = false,
    val isFollowing: Boolean = false,
    val productDetail: ProductDetailCardUiModel? = null,
    val storeProducts: ImmutableList<StoreProductItem> = persistentListOf()
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
            )
        )
    }
}

sealed interface ProductDetailSideEffect {
    data object NavigateUp : ProductDetailSideEffect
    data object NavigateToHome : ProductDetailSideEffect
    data object NavigateToPurchase : ProductDetailSideEffect
}