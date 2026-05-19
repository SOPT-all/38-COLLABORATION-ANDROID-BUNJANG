package com.sopt.bunjang.presentation.productdetail.model

import androidx.compose.runtime.Immutable

@Immutable
data class ProductRecommendItem(
    val id: Long,
    val imageUrl: String,
    val price: Int,
    val title: String,
    val time: String,
    val likes: Int,
    val isLike: Boolean = false,
    val isAd: Boolean = false
)