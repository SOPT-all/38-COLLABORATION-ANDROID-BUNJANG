package com.sopt.bunjang.data.home.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class LikeDataDto(
    val productId: Long,
    val isLiked: Boolean,
    val likeCount: Int
)