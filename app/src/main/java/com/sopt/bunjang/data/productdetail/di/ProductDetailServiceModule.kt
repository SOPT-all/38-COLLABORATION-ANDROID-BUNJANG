package com.sopt.bunjang.data.productdetail.di

import com.sopt.bunjang.data.productdetail.remote.api.ProductDetailService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductDetailServiceModule {
    @Provides
    @Singleton
    fun provideProductDetailService(retrofit: Retrofit): ProductDetailService =
        retrofit.create()
}