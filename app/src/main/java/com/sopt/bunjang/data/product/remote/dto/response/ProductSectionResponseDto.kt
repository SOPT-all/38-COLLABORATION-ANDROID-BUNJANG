package com.sopt.bunjang.data.product.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductSectionResponseDto(
    @SerialName("recommendedProducts")
    val recommendedProducts: RecommendedProductsDto,
    @SerialName("relatedStyleProducts")
    val relatedStyleProducts: List<RelatedStyleProductDto>
)

@Serializable
data class RecommendedProductsDto(
    @SerialName("nickname")
    val nickname: String,
    @SerialName("remainingCount")
    val remainingCount: Int,
    @SerialName("products")
    val products: List<RecommendProductItemDto>
)

@Serializable
data class RecommendProductItemDto(
    @SerialName("productId")
    val productId: Long,
    @SerialName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerialName("price")
    val price: Int,
    @SerialName("productName")
    val productName: String,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("isLiked")
    val isLiked: Boolean,
    @SerialName("likeCount")
    val likeCount: Int
)

@Serializable
data class RelatedStyleProductDto(
    @SerialName("bannerThumbnailUrl")
    val bannerThumbnailUrl: String,
    @SerialName("products")
    val products: List<RelatedProductItemDto>
)

@Serializable
data class RelatedProductItemDto(
    @SerialName("productId")
    val productId: Long,
    @SerialName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerialName("price")
    val price: Int,
    @SerialName("productName")
    val productName: String,
    @SerialName("isLiked")
    val isLiked: Boolean
)