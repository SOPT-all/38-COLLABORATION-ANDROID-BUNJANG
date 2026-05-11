package com.sopt.bunjang.core.designsystem.component

data class ProductCardState(
    val imageUrl: String,
    val price: Int,
    val title: String,
    val createdAt: String? = null,
    val isAd: Boolean = false,
    val isFavorite: Boolean = false,
    val favoriteCount: Int? = null,
) {
    val formattedPrice: String
        get() = "%,d".format(price) + "원"
}