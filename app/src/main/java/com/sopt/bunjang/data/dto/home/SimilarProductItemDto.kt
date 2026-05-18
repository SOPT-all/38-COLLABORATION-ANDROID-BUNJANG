package com.sopt.bunjang.data.dto.home

import kotlinx.serialization.Serializable

@Serializable
data class SimilarProductDto(
    val productId: Long,
    val thumbnailUrl: String,
    val price: Int,
    val productName: String,
    val isLiked: Boolean
)
//fun SimilarProductDto.toEntity() = com.sopt.bunjang.domain.entity.Product(
//    productId = productId,
//    thumbnailUrl = thumbnailUrl,
//    price = price,
//    productName = productName,
//    isLiked = isLiked
//)
