package com.sopt.bunjang.data.productdetail.remote.dto.response

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ProductDetailDataDto(
    @SerialName("product") val product: ProductDto,
    @SerialName("seller") val seller: SellerDto
)
