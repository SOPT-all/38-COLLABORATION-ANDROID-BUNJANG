package com.sopt.bunjang.data.home.repositoryimpl

import com.sopt.bunjang.core.util.suspendRunCatching
import com.sopt.bunjang.data.home.mapper.toGlassesModel
import com.sopt.bunjang.data.home.remote.datasource.HomeRemoteDataSource
import com.sopt.bunjang.data.home.repository.HomeRepository
import com.sopt.bunjang.presentation.home.model.HomeGlassesProduct
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getHome(userId: Long): Result<List<HomeGlassesProduct>> = suspendRunCatching {
        homeRemoteDataSource.getHome(userId).data!!.recentCategoryProducts.products.map { it.toGlassesModel() }
    }
}