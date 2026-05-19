package com.sopt.bunjang.data.product.di

import com.sopt.bunjang.data.product.repository.ProductRepository
import com.sopt.bunjang.data.product.repositoryimpl.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ProductRepositoryModule {
    @Binds
    @Singleton
    fun bindsProductRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ) : ProductRepository
}