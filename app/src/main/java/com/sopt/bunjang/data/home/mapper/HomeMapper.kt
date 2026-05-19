package com.sopt.bunjang.data.home.mapper

import com.sopt.bunjang.data.home.remote.dto.response.HomeProductItemDto
import com.sopt.bunjang.presentation.home.model.HomeGlassesProduct
import com.sopt.bunjang.presentation.home.model.HomeKidultProduct
import com.sopt.bunjang.presentation.home.model.HomeSimilarProduct

fun HomeProductItemDto.toGlassesModel() = HomeGlassesProduct(
    id = productId,
    imageUrl = thumbnailUrl,
    price = price,
    title = productName,
    time = createdAt,
    isLike = isLiked,
    likes = likeCount
)

fun HomeProductItemDto.toSimilarModel() = HomeSimilarProduct(
    id = productId,
    imageUrl = thumbnailUrl,
    price = price,
    title = productName
)

fun HomeProductItemDto.toKidultModel() = HomeKidultProduct(
    id = productId,
    imageUrl = thumbnailUrl,
    price = price,
    title = productName,
    time = createdAt,
    isLike = isLiked,
    likes = likeCount
)