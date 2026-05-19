package com.sopt.bunjang.presentation.home.model

import androidx.compose.runtime.Immutable

@Immutable
data class HomeSimilarProduct(
    val id: Long,
    val imageUrl: String,
    val price: Int,
    val title: String,
    val isAd: Boolean = false
)