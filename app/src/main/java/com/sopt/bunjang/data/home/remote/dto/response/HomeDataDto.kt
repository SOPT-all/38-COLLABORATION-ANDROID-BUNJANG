package com.sopt.bunjang.data.home.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class HomeDataDto(
    val recentCategoryProducts: GlassesProductsDto,
    val similarProducts: SimilarProductsDto,
    val adProducts: AdProductsDto
)