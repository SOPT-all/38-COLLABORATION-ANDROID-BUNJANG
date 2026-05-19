package com.sopt.bunjang.data.home.repositoryimpl

import com.sopt.bunjang.data.home.remote.datasource.HomeRemoteDataSource
import com.sopt.bunjang.data.home.remote.dto.response.HomeResponseDto
import com.sopt.bunjang.data.home.repository.HomeRepository

class HomeRepositoryImpl(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getHome(userId: Long): Result<HomeResponseDto> {
        return runCatching {
            homeRemoteDataSource.getHome(userId)
        }
    }
}