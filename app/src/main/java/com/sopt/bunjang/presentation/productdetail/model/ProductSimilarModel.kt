package com.sopt.bunjang.presentation.productdetail.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class ProductSimilarGroup(
    val tags: ImmutableList<String>,
    val bannerTitle: String,
    val bannerSubtitle: String,
    val bannerImageUrl: String,
    val products: ImmutableList<ProductSimilarItem>
)

@Immutable
data class ProductSimilarItem(
    val id: Long,
    val imageUrl: String,
    val price: Int,
    val title: String,
    val isLike: Boolean = false
)