package com.sopt.bunjang.presentation.purchase.state

import androidx.compose.runtime.Immutable
import com.sopt.bunjang.presentation.purchase.model.PurchaseProductItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
data class PurchaseUiState(
    val shopName: String = "",
    val productName: String = "",
    val noticeTime: String = "",
    val recommendProducts: ImmutableList<PurchaseProductItem> = persistentListOf()
) {
    companion object {
        val dummy = PurchaseUiState(
            shopName = "혁줌마",
            productName = "안경닦이",
            noticeTime = "오후11:20",
            recommendProducts = listOf(
                PurchaseProductItem(
                    id = 1,
                    imageUrl = "https://picsum.photos/200",
                    price = 10000,
                    title = "상품명",
                    isLike = false,
                    isAd = true
                ),
                PurchaseProductItem(
                    id = 2,
                    imageUrl = "https://picsum.photos/200",
                    price = 10000,
                    title = "상품명",
                    isLike = false
                ),
                PurchaseProductItem(
                    id = 3,
                    imageUrl = "https://picsum.photos/200",
                    price = 10000,
                    title = "상품명",
                    isLike = false
                ),
                PurchaseProductItem(
                    id = 4,
                    imageUrl = "https://picsum.photos/200",
                    price = 10000,
                    title = "상품명",
                    isLike = false
                ),
                PurchaseProductItem(
                    id = 5,
                    imageUrl = "https://picsum.photos/200",
                    price = 10000,
                    title = "상품명",
                    isLike = false
                ),
                PurchaseProductItem(
                    id = 6,
                    imageUrl = "https://picsum.photos/200",
                    price = 10000,
                    title = "상품명",
                    isLike = false
                )
            ).toImmutableList()
        )
    }
}

sealed interface PurchaseSideEffect {
    data class NavigateToProductDetail(val id: Long) : PurchaseSideEffect
}