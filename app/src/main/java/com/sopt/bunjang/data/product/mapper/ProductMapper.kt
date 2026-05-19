// ProductMapper.kt
package com.sopt.bunjang.data.product.mapper

import com.sopt.bunjang.data.product.model.ProductSectionModel
import com.sopt.bunjang.data.product.model.PurchaseProductModel
import com.sopt.bunjang.data.product.model.RecommendProductItemModel
import com.sopt.bunjang.data.product.model.RecommendedProductsModel
import com.sopt.bunjang.data.product.model.RelatedProductItemModel
import com.sopt.bunjang.data.product.model.RelatedStyleProductModel
import com.sopt.bunjang.data.product.remote.dto.response.BoughtTogetherProductItemDto
import com.sopt.bunjang.data.product.remote.dto.response.ProductSectionResponseDto
import com.sopt.bunjang.data.product.remote.dto.response.RecommendProductItemDto
import com.sopt.bunjang.data.product.remote.dto.response.RecommendedProductsDto
import com.sopt.bunjang.data.product.remote.dto.response.RelatedProductItemDto
import com.sopt.bunjang.data.product.remote.dto.response.RelatedStyleProductDto

fun ProductSectionResponseDto.toModel() = ProductSectionModel(
    recommendedProducts = recommendedProducts.toModel(),
    relatedStyleProducts = relatedStyleProducts.map { it.toModel() }
)

fun RecommendedProductsDto.toModel() = RecommendedProductsModel(
    nickname = nickname,
    remainingCount = remainingCount,
    products = products.map { it.toModel() }
)

fun RecommendProductItemDto.toModel() = RecommendProductItemModel(
    productId = productId,
    thumbnailUrl = thumbnailUrl,
    price = price,
    productName = productName,
    createdAt = createdAt,
    isLiked = isLiked,
    likeCount = likeCount
)

fun RelatedStyleProductDto.toModel() = RelatedStyleProductModel(
    bannerThumbnailUrl = bannerThumbnailUrl,
    products = products.map { it.toModel() }
)

fun RelatedProductItemDto.toModel() = RelatedProductItemModel(
    productId = productId,
    thumbnailUrl = thumbnailUrl,
    price = price,
    productName = productName,
    isLiked = isLiked
)

fun BoughtTogetherProductItemDto.toModel() = PurchaseProductModel(
    productId = productId,
    thumbnailUrl = thumbnailUrl,
    price = price,
    productName = productName,
    isLiked = isLiked
)