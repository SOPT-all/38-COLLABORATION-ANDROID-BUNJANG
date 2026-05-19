package com.sopt.bunjang.presentation.productdetail.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class ProductDetailCardUiModel(
    val id: Long,
    val imageUrls: ImmutableList<String>,
    val title: String,
    val price: Int,
    val time: String? = null,
    val views: Int? = null,
    val likes: Int? = null,
    val comments: Int? = null,
)