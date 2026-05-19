package com.sopt.bunjang.presentation.productdetail.model

import androidx.compose.runtime.Immutable

@Immutable
data class SellerInfoUiModel(
    val storeName: String,
    val rating: Double,
    val reviewCount: Int,
    val transactionCount: Int,
)
