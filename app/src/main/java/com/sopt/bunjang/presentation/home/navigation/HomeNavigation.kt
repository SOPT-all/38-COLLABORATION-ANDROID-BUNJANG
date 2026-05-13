package com.sopt.bunjang.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.bunjang.core.navigation.MainTabRoute
import com.sopt.bunjang.presentation.home.HomeRoute
import kotlinx.serialization.Serializable

fun NavController.navigateHome(navOptions: NavOptions? = null) {
    navigate(Home, navOptions)
}

fun NavGraphBuilder.homeGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToProductDetail: () -> Unit
) {
    composable<Home> {
        HomeRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            navigateToProductDetail = navigateToProductDetail
        )
    }
}

@Serializable
data object Home : MainTabRoute