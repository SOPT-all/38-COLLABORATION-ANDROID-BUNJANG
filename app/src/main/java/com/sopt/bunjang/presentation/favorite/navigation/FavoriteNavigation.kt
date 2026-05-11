package com.sopt.bunjang.presentation.favorite.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.bunjang.core.navigation.MainTabRoute
import com.sopt.bunjang.presentation.favorite.FavoriteRoute
import kotlinx.serialization.Serializable

fun NavController.navigateFavorite(navOptions: NavOptions? = null) {
    navigate(Favorite, navOptions)
}

fun NavGraphBuilder.favoriteGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Favorite> {
        FavoriteRoute()
    }
}

@Serializable
data object Favorite : MainTabRoute