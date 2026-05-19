package com.sopt.bunjang.data.productdetail.di

import com.sopt.bunjang.data.productdetail.remote.datasource.ProductDetailDataSource
import com.sopt.bunjang.data.productdetail.remote.datasourceimpl.ProductDetailDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductDetailDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindProductDetailDataSource(
        productDetailDataSourceImpl: ProductDetailDataSourceImpl
    ): ProductDetailDataSource
}