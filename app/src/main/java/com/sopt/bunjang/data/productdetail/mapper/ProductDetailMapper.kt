package com.sopt.bunjang.data.productdetail.mapper

import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDetailResponseDto
import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDto
import com.sopt.bunjang.data.productdetail.remote.dto.response.SellerProductDto
import com.sopt.bunjang.presentation.productdetail.model.ProductDetailCardUiModel
import com.sopt.bunjang.presentation.productdetail.model.StoreProductItem
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailTopUiState
import kotlinx.collections.immutable.toImmutableList

fun ProductDetailResponseDto.toUiState(): ProductDetailTopUiState =
    ProductDetailTopUiState(
        isLike = data.product.isLiked,
        isFollowing = data.seller.isFollowing,
        productDetail = data.product.toUiModel(),
        storeProducts = data.seller.sellerProducts.map { it.toUiModel() }.toImmutableList()
    )

fun ProductDto.toUiModel(): ProductDetailCardUiModel =
    ProductDetailCardUiModel(
        id = productId,
        imageUrls = imageUrls.toImmutableList(),
        title = productName,
        price = price,
        likes = likeCount,
        views = viewCount,
        comments = chatCount,
        time = createdAt
    )

fun SellerProductDto.toUiModel(): StoreProductItem =
    StoreProductItem(
        id = productId,
        imageUrl = thumbnailUrl,
        title = productName,
        price = price,
        likes = likeCount
    )