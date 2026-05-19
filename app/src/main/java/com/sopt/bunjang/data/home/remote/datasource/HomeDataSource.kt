package com.sopt.bunjang.data.home.remote.datasource

import com.sopt.bunjang.data.home.remote.dto.response.HomeResponseDto
import com.sopt.bunjang.data.home.remote.dto.response.LikeResponseDto

interface HomeRemoteDataSource {
    suspend fun getHome(userId: Long): HomeResponseDto
    suspend fun toggleLike(productId: Long, userId: Long): LikeResponseDto
}