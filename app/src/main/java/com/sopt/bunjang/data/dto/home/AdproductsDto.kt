package com.sopt.bunjang.data.dto.home

import kotlinx.serialization.Serializable

@Serializable
data class AdProductsDto(
    val categoryName: String,
    val products: List<HomeProductDto>
)