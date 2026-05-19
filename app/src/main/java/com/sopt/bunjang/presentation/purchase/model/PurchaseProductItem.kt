package com.sopt.bunjang.presentation.purchase.model

import androidx.compose.runtime.Immutable

@Immutable
data class PurchaseProductItem (
    val id: Long,
    val imageUrl: String,
    val price: Int,
    val title: String,
    val isLike: Boolean,
    val isAd: Boolean = false
)