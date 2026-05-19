package com.sopt.bunjang.data.home.di

import com.sopt.bunjang.data.home.repository.HomeRepository
import com.sopt.bunjang.data.home.repositoryimpl.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface HomeRepositoryModule {
    @Binds
    @Singleton
    fun bindsHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}