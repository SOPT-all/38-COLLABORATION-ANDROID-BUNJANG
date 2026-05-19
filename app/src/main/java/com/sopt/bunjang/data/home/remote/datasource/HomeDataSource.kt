package com.sopt.bunjang.data.home.remote.datasource

import com.sopt.bunjang.data.home.remote.dto.response.HomeResponseDto

interface HomeRemoteDataSource {
    suspend fun getHome(userId: Long): HomeResponseDto
}