package com.sopt.bunjang.data.product.di

import com.sopt.bunjang.data.product.remote.datasource.ProductDataSource
import com.sopt.bunjang.data.product.remote.datasourceimpl.ProductDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindProductDataSource(
        productDataSourceImpl: ProductDataSourceImpl
    ): ProductDataSource
}