package com.sopt.bunjang.data.product.remote.api

import com.sopt.bunjang.core.network.model.BaseResponse
import com.sopt.bunjang.data.product.remote.dto.response.PaymentCompleteResponseDto
import com.sopt.bunjang.data.product.remote.dto.response.ProductSectionResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {
    @GET("api/v1/products/{productId}/sections")
    suspend fun getProductSections(
        @Path("productId") productId: Long,
        @Query("userId") userId: Long
    ): BaseResponse<ProductSectionResponseDto>

    @GET("api/v1/products/{productId}/payment-complete")
    suspend fun getPaymentComplete(
        @Path("productId") productId: Long,
        @Query("userId") userId: Long
    ): BaseResponse<PaymentCompleteResponseDto>
}