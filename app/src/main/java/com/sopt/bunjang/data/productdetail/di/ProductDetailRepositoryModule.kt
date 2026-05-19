package com.sopt.bunjang.data.productdetail.di

import com.sopt.bunjang.data.productdetail.repository.ProductDetailRepository
import com.sopt.bunjang.data.productdetail.repositoryimpl.ProductDetailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ProductDetailRepositoryModule {
    @Binds
    @Singleton
    fun bindsProductDetailRepository(
        productDetailRepositoryImpl: ProductDetailRepositoryImpl
    ): ProductDetailRepository
}