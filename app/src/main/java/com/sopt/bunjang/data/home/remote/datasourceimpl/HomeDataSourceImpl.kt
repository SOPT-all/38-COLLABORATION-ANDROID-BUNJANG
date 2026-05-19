package com.sopt.bunjang.data.home.remote.datasourceimpl

import com.sopt.bunjang.data.home.remote.api.HomeService
import com.sopt.bunjang.data.home.remote.datasource.HomeRemoteDataSource
import com.sopt.bunjang.data.home.remote.dto.response.HomeResponseDto

class HomeRemoteDataSourceImpl(
    private val homeService: HomeService
) : HomeRemoteDataSource {
    override suspend fun getHome(userId: Long): HomeResponseDto {
        return homeService.getHome(userId)
    }
}