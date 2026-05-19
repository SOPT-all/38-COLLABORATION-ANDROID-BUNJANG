package com.sopt.bunjang.data.productdetail.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDetailResponseDto

interface ProductDetailService {
    @GET("/api/v1/products/{productId}")
    suspend fun getProductDetail(
        @Path("productId") productId: Long,
        @Query("userId") userId: Long
    ): ProductDetailResponseDto
}