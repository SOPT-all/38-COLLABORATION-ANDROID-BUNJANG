package com.sopt.bunjang.data.home.mapper

import com.sopt.bunjang.data.home.remote.dto.response.HomeProductItemDto
import com.sopt.bunjang.presentation.home.model.HomeGlassesProduct

fun HomeProductItemDto.toGlassesModel() = HomeGlassesProduct(
    id = productId,
    imageUrl = thumbnailUrl,
    price = price,
    title = productName,
    time = createdAt,
    isLike = isLiked,
    likes = likeCount
)