package com.sopt.bunjang.presentation.productdetail.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class ProductInfoUiModel(
    val categories: ImmutableList<String>,
    val condition: String,
    val quantity: Int,
    val description: String,
    val deliveryFee: Int,
)
