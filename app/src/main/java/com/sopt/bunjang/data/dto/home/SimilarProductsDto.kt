package com.sopt.bunjang.data.dto.home

import kotlinx.serialization.Serializable

@Serializable
data class SimilarProductsDto(
    val productId: Long,
    val thumbnailUrl: String,
    val price: Int,
    val productName: String,
    val isLiked: Boolean
)