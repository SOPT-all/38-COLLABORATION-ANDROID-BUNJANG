package com.sopt.bunjang.data.home.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class HomeResponseDto(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val data: HomeDataDto? = null
)