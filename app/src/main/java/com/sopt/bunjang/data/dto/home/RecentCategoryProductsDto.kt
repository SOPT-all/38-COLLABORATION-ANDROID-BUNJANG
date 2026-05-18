package com.sopt.bunjang.data.dto.home

import kotlinx.serialization.Serializable

@Serializable
data class RecentCategoryProductsDto(
    val nickname: String,
    val categoryName: String,
    val remainingCount: Int,
    val products: List<HomeProductDto>
)