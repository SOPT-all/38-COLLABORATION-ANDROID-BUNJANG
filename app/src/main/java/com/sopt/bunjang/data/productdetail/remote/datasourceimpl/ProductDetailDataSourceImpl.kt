package com.sopt.bunjang.data.productdetail.remote.datasourceimpl

import com.sopt.bunjang.data.productdetail.remote.api.ProductDetailService
import com.sopt.bunjang.data.productdetail.remote.datasource.ProductDetailDataSource
import javax.inject.Inject

class ProductDetailDataSourceImpl @Inject constructor(
    private val productDetailService: ProductDetailService,
) : ProductDetailDataSource {
    override suspend fun getProductDetail(
        productId: Long,
        userId: Long
    ) = productDetailService.getProductDetail(productId, userId)
}
