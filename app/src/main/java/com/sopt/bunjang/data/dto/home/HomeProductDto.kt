package com.sopt.bunjang.data.dto.home

import kotlinx.serialization.Serializable

@Serializable
data class HomeProductDto(
    val productId: Long,
    val thumbnailUrl: String,
    val price: Int,
    val productName: String,
    val createdAt: String? = null,
    val isLiked: Boolean,
    val likeCount: Int? = null
)

//@Serializable
//data class HomeProductResponseDto(
//    val products: List<HomeProductDto>
//)

//fun HomeProductDto.toEntity() = com.sopt.bunjang.domain.entity.Product(
//    productId = productId,
//    thumbnailUrl = thumbnailUrl,
//    price = price,
//    productName = productName,
//    isLiked = isLiked
//)