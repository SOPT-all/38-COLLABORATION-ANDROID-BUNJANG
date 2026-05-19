package com.sopt.bunjang.data.productdetail.remote.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailResponseDto(
    @SerialName("isSuccess") val isSuccess: Boolean,
    @SerialName("code") val code: String,
    @SerialName("message") val message: String,
    @SerialName("data") val data: ProductDetailDataDto
)
