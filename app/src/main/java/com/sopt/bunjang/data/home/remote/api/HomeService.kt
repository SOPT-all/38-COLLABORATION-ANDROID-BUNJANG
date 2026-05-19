package com.sopt.bunjang.data.home.remote.api

import com.sopt.bunjang.data.home.remote.dto.response.HomeResponseDto
import com.sopt.bunjang.data.home.remote.dto.response.LikeResponseDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeService {
    @GET("api/v1/home")
    suspend fun getHome(
        @Query("userId") userId: Long
    ): HomeResponseDto

    @POST("api/v1/products/{productId}/like")
    suspend fun toggleLike(
        @Path("productId") productId: Long,
        @Query("userId") userId: Long
    ): LikeResponseDto
}