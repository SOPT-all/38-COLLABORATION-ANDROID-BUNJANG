package com.sopt.bunjang.data.product.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaymentCompleteResponseDto(
    @SerialName("boughtTogetherProducts")
    val boughtTogetherProducts: BoughtTogetherProductsDto
)

@Serializable
data class BoughtTogetherProductsDto(
    @SerialName("products")
    val products: List<BoughtTogetherProductItemDto>
)

@Serializable
data class BoughtTogetherProductItemDto(
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