package com.sopt.bunjang.data.productdetail.remote.datasource

import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDetailResponseDto

interface ProductDetailDataSource {
    suspend fun getProductDetail(
        productId: Long,
        userId: Long
    ): ProductDetailResponseDto
}