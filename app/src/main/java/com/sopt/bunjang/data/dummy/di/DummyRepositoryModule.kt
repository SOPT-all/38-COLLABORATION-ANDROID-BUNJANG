package com.sopt.bunjang.data.dummy.di

import com.sopt.bunjang.data.dummy.repository.DummyRepository
import com.sopt.bunjang.data.dummy.repositoryimpl.DummyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DummyRepositoryModule {
    @Binds
    @Singleton
    fun bindsDummyRepository(
        dummyRepositoryImpl: DummyRepositoryImpl
    ) : DummyRepository
}