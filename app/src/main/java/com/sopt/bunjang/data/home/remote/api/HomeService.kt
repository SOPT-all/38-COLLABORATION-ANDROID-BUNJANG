package com.sopt.bunjang.data.home.remote.api

import com.sopt.bunjang.data.home.remote.dto.response.HomeResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService {
    @GET("api/v1/home")
    suspend fun getHome(
        @Query("userId") userId: Long
    ): HomeResponseDto
}