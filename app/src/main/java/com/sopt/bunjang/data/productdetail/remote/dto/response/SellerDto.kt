package com.sopt.bunjang.data.productdetail.remote.dto.response

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class SellerDto(
    @SerialName("sellerId") val sellerId: Long,
    @SerialName("nickname") val nickname: String,
    @SerialName("rate") val rate: Double,
    @SerialName("reviewCount") val reviewCount: Int,
    @SerialName("salesCount") val salesCount: Int,
    @SerialName("isFollowing") val isFollowing: Boolean,
    @SerialName("sellerProducts") val sellerProducts: List<SellerProductDto>
)