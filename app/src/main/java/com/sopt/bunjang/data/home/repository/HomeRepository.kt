package com.sopt.bunjang.data.home.repository

import com.sopt.bunjang.data.home.remote.dto.response.HomeResponseDto

interface HomeRepository {
    suspend fun getHome(userId: Long): Result<HomeResponseDto>
}