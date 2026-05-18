package com.sopt.bunjang.data.product.remote.datasource

import com.sopt.bunjang.core.network.model.BaseResponse
import com.sopt.bunjang.data.product.remote.dto.response.PaymentCompleteResponseDto
import com.sopt.bunjang.data.product.remote.dto.response.ProductSectionResponseDto


interface ProductDataSource {
    suspend fun getProductSections(
        productId: Long,
        userId: Long
    ): BaseResponse<ProductSectionResponseDto>

    suspend fun getPaymentComplete(
        productId: Long,
        userId: Long
    ): BaseResponse<PaymentCompleteResponseDto>
}