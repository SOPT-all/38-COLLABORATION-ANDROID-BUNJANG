package com.sopt.bunjang.data.dto.home

import kotlinx.serialization.Serializable

@Serializable
data class HomeDataDto(
    val recentCategoryProducts: RecentCategoryProductsDto,
    val similarProducts: SimilarProductsDto,
    val adProducts: AdProductsDto
)