package com.sopt.bunjang.data.productdetail.remote.datasource

import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDetailResponseDto
import retrofit2.Response

interface ProductDetailDataSource {
    suspend fun getProductDetail(
        productId: Long,
        userId: Long
    ): ProductDetailResponseDto
}