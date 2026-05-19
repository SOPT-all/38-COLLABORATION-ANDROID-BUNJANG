package com.sopt.bunjang.data.home.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class GlassesProductsDto(
    val nickname: String,
    val categoryName: String,
    val remainingCount: Int,
    val products: List<HomeProductItemDto>
)