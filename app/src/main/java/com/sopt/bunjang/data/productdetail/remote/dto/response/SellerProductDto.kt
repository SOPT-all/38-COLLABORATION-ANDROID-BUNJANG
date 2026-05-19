package com.sopt.bunjang.data.productdetail.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerProductDto(
    @SerialName("productId") val productId: Long,
    @SerialName("thumbnailUrl") val thumbnailUrl: String,
    @SerialName("productName") val productName: String,
    @SerialName("price") val price: Int,
    @SerialName("likeCount") val likeCount: Int
)
