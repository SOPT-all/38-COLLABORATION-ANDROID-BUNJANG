package com.sopt.bunjang.data.home.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class SimilarProductsDto(
    val products: List<HomeProductItemDto>
)