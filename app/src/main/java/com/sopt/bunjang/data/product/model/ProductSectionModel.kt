package com.sopt.bunjang.data.product.model

data class ProductSectionModel(
    val recommendedProducts: RecommendedProductsModel,
    val relatedStyleProducts: List<RelatedStyleProductModel>
)

data class RecommendedProductsModel(
    val nickname: String,
    val remainingCount: Int,
    val products: List<RecommendProductItemModel>
)

data class RecommendProductItemModel(
    val productId: Long,
    val thumbnailUrl: String,
    val price: Int,
    val productName: String,
    val createdAt: String,
    val isLiked: Boolean,
    val likeCount: Int
)

data class RelatedStyleProductModel(
    val bannerThumbnailUrl: String,
    val products: List<RelatedProductItemModel>
)

data class RelatedProductItemModel(
    val productId: Long,
    val thumbnailUrl: String,
    val price: Int,
    val productName: String,
    val isLiked: Boolean
)