package com.sopt.bunjang.data.product.repository

import com.sopt.bunjang.data.product.model.ProductSectionModel
import com.sopt.bunjang.data.product.model.PurchaseProductModel

interface ProductRepository {
    suspend fun getProductSections(
        productId: Long,
        userId: Long
    ): Result<ProductSectionModel>

    suspend fun getBoughtTogetherProducts(
        productId: Long,
        userId: Long
    ): Result<List<PurchaseProductModel>>
}