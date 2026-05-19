package com.sopt.bunjang.data.home.repository

import com.sopt.bunjang.data.home.remote.dto.response.HomeResponseDto
import com.sopt.bunjang.presentation.home.model.HomeGlassesProduct

interface HomeRepository {
    suspend fun getHome(userId: Long): Result<List<HomeGlassesProduct>>
}