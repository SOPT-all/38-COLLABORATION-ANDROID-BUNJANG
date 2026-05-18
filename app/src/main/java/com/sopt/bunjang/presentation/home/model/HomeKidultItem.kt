package com.sopt.bunjang.presentation.home.model

import androidx.compose.runtime.Immutable

@Immutable
data class HomeKidultProduct(
    val imageUrl: String,
    val price: Int,
    val title: String,
    val time: String? = null,
    val isLike: Boolean = false,
    val likes: Int? = null
)