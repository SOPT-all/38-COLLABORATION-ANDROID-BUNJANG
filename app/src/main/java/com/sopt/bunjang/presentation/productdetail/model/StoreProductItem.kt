package com.sopt.bunjang.presentation.productdetail.model

import androidx.compose.runtime.Immutable

@Immutable
data class StoreProductItem(
    val id: Long,
    val imageUrl: String,
    val title: String,
    val price: Int,
    val likes: Int? = null
)