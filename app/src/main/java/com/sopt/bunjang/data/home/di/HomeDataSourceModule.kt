package com.sopt.bunjang.data.home.di

import com.sopt.bunjang.data.home.remote.datasource.HomeRemoteDataSource
import com.sopt.bunjang.data.home.remote.datasourceimpl.HomeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindHomeDataSource(
        homeRemoteDataSourceImpl: HomeRemoteDataSourceImpl
    ): HomeRemoteDataSource
}