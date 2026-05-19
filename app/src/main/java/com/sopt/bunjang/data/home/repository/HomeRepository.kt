package com.sopt.bunjang.data.home.repository

import com.sopt.bunjang.data.home.model.HomeModel
import com.sopt.bunjang.data.home.remote.dto.response.LikeDataDto

interface HomeRepository {
    suspend fun getHome(userId: Long): Result<HomeModel>
    suspend fun toggleLike(productId: Long, userId: Long): Result<LikeDataDto>
}