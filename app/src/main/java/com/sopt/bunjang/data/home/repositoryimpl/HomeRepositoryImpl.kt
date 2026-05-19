package com.sopt.bunjang.data.home.repositoryimpl

import com.sopt.bunjang.core.util.suspendRunCatching
import com.sopt.bunjang.data.home.mapper.toGlassesModel
import com.sopt.bunjang.data.home.mapper.toKidultModel
import com.sopt.bunjang.data.home.mapper.toSimilarModel
import com.sopt.bunjang.data.home.model.HomeModel
import com.sopt.bunjang.data.home.remote.datasource.HomeRemoteDataSource
import com.sopt.bunjang.data.home.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getHome(userId: Long): Result<HomeModel> = suspendRunCatching {
        val response = homeRemoteDataSource.getHome(userId).data!!
        HomeModel(
            glassesProducts = response.recentCategoryProducts.products.map { it.toGlassesModel() },
            similarProducts = response.similarProducts.products.map { it.toSimilarModel() },
            kidultProducts = response.adProducts.products.map { it.toKidultModel() },
            userName = response.recentCategoryProducts.nickname,
            productCount = response.recentCategoryProducts.remainingCount
        )
    }
}