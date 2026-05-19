package com.sopt.bunjang.data.productdetail.repositoryimpl

import com.sopt.bunjang.data.productdetail.remote.datasource.ProductDetailDataSource
import com.sopt.bunjang.data.productdetail.remote.dto.response.ProductDetailResponseDto
import com.sopt.bunjang.data.productdetail.repository.ProductDetailRepository
import jakarta.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDetailRepositoryImpl @Inject constructor(
    private val productDetailDataSource: ProductDetailDataSource
) : ProductDetailRepository {
    override suspend fun getProductDetail(
        productId: Long,
        userId: Long
    ): Result<ProductDetailResponseDto> {
        return runCatching {
            productDetailDataSource.getProductDetail(productId, userId)
        }
    }
}