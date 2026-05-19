package com.sopt.bunjang.data.product.model

data class PurchaseProductModel(
    val productId: Long,
    val thumbnailUrl: String,
    val price: Int,
    val productName: String,
    val isLiked: Boolean
)