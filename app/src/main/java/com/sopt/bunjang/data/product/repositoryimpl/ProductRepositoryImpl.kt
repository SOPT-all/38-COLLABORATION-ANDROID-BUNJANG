package com.sopt.bunjang.data.product.repositoryimpl

import com.sopt.bunjang.core.util.suspendRunCatching
import com.sopt.bunjang.data.product.mapper.toModel
import com.sopt.bunjang.data.product.model.ProductSectionModel
import com.sopt.bunjang.data.product.model.PurchaseProductModel
import com.sopt.bunjang.data.product.remote.datasource.ProductDataSource
import com.sopt.bunjang.data.product.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource
) : ProductRepository {

    override suspend fun getProductSections(
        productId: Long,
        userId: Long
    ): Result<ProductSectionModel> = suspendRunCatching {
        productDataSource.getProductSections(productId, userId).data!!.toModel()
    }

    override suspend fun getBoughtTogetherProducts(
        productId: Long,
        userId: Long
    ): Result<List<PurchaseProductModel>> = suspendRunCatching {
        productDataSource.getPaymentComplete(productId, userId)
            .data!!.boughtTogetherProducts.products.map { it.toModel() }
    }
}