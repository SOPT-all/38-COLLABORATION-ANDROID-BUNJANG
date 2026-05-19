package com.sopt.bunjang.data.product.remote.datasourceimpl

import com.sopt.bunjang.data.product.remote.api.ProductService
import com.sopt.bunjang.data.product.remote.datasource.ProductDataSource
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(
    private val productService: ProductService,
) : ProductDataSource {
    override suspend fun getProductSections(
        productId: Long,
        userId: Long
    ) = productService.getProductSections(productId, userId)

    override suspend fun getPaymentComplete(
        productId: Long, userId: Long
    ) = productService.getPaymentComplete(productId, userId)
}