package com.sopt.bunjang.data.productdetail.repository

import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDetailResponseDto

interface ProductDetailRepository {
    suspend fun getProductDetail(
        productId: Long,
        userId: Long
    ): Result<ProductDetailResponseDto>
}