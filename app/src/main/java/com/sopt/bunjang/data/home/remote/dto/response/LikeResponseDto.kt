package com.sopt.bunjang.data.home.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class LikeResponseDto(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val data: LikeDataDto? = null
)