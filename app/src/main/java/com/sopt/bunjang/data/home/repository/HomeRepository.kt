package com.sopt.bunjang.data.home.repository

import com.sopt.bunjang.data.home.model.HomeModel

interface HomeRepository {
    suspend fun getHome(userId: Long): Result<HomeModel>
}