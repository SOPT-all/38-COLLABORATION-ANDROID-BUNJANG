package com.sopt.bunjang.data.home.model

import com.sopt.bunjang.presentation.home.model.HomeGlassesProduct
import com.sopt.bunjang.presentation.home.model.HomeKidultProduct
import com.sopt.bunjang.presentation.home.model.HomeSimilarProduct

data class HomeModel(
    val glassesProducts: List<HomeGlassesProduct>,
    val similarProducts: List<HomeSimilarProduct>,
    val kidultProducts: List<HomeKidultProduct>,
    val userName: String,
    val productCount: Int
)