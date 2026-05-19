package com.sopt.bunjang.data.home.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class AdProductsDto(
    val categoryName: String,
    val products: List<HomeProductItemDto>
)