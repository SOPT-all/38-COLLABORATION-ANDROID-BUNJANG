package com.sopt.bunjang.data.productdetail.mapper

import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDetailResponseDto
import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDto
import com.sopt.bunjang.data.productdetail.remote.dto.response.SellerProductDto
import com.sopt.bunjang.presentation.productdetail.model.ProductDetailCardUiModel
import com.sopt.bunjang.presentation.productdetail.model.ProductInfoUiModel
import com.sopt.bunjang.presentation.productdetail.model.SellerInfoUiModel
import com.sopt.bunjang.presentation.productdetail.model.StoreProductItem
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailTopUiState
import kotlinx.collections.immutable.toImmutableList

fun ProductDetailResponseDto.toTopUiState(): ProductDetailTopUiState =
    ProductDetailTopUiState(
        isLike = data.product.isLiked,
        isFollowing = data.seller.isFollowing,
        productDetail = data.product.toUiModel(),
        storeProducts = data.seller.sellerProducts.map { it.toUiModel() }.toImmutableList(),

        productInfo = ProductInfoUiModel(
            categories = listOf(data.product.category.toKoreanCategory()).toImmutableList(),
            condition = data.product.productCondition.toKoreanCondition(),
            quantity = data.product.quantity,
            description = data.product.description,
            deliveryFee = data.product.deliveryFee
        ),

        sellerInfo = SellerInfoUiModel(
            storeName = data.seller.nickname,
            rating = data.seller.rate,
            reviewCount = data.seller.reviewCount,
            transactionCount = data.seller.salesCount
        )
    )

private fun String.toKoreanCategory(): String {
    return when (this) {
        "GLASSES" -> "안경"
        "KIDULT" -> "키덜트"
        else -> this
    }
}

private fun String.toKoreanCondition(): String {
    return when (this) {
        "NEW" -> "새 상품"
        "LIKE_NEW" -> "사용감 없음"
        "LIGHTLY_USED" -> "사용감 적음"
        "HEAVILY_USED" -> "사용감 많음"
        "BROKEN" -> "고장/파손"
        else -> this
    }
}

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