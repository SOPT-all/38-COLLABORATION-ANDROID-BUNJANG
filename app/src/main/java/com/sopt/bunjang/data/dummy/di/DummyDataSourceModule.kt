package com.sopt.bunjang.data.dummy.di

import com.sopt.bunjang.data.dummy.remote.datasource.DummyDataSource
import com.sopt.bunjang.data.dummy.remote.datasourceimpl.DummyDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DummyDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindDummyDataSource(
        dummyDataSourceImpl: DummyDataSourceImpl
    ): DummyDataSource
}