package com.sopt.bunjang.presentation.purchase.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.bunjang.core.navigation.Route
import com.sopt.bunjang.presentation.purchase.PurChaseRoute
import kotlinx.serialization.Serializable

fun NavController.navigatePurChase(navOptions: NavOptions? = null) {
    navigate(PurChase, navOptions)
}

fun NavGraphBuilder.purChaseGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<PurChase> {
        PurChaseRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp
        )
    }
}

@Serializable
data object PurChase : Route