package com.sopt.bunjang.data.productdetail.remote.dto.response

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ProductDto(
    @SerialName("productId") val productId: Long,
    @SerialName("imageUrls") val imageUrls: List<String>,
    @SerialName("productName") val productName: String,
    @SerialName("price") val price: Int,
    @SerialName("isLiked") val isLiked: Boolean,
    @SerialName("likeCount") val likeCount: Int,
    @SerialName("viewCount") val viewCount: Int,
    @SerialName("chatCount") val chatCount: Int,
    @SerialName("createdAt") val createdAt: String,
    @SerialName("category") val category: String,
    @SerialName("productCondition") val productCondition: String,
    @SerialName("quantity") val quantity: Int,
    @SerialName("description") val description: String,
    @SerialName("deliveryFee") val deliveryFee: Int
)
