package com.sopt.bunjang.presentation.purchase.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.bunjang.core.navigation.Route
import com.sopt.bunjang.presentation.purchase.PurchaseRoute
import kotlinx.serialization.Serializable

fun NavController.navigatePurchase(navOptions: NavOptions? = null) {
    navigate(Purchase, navOptions)
}

fun NavGraphBuilder.purchaseGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToProductDetail: (Long) -> Unit
) {
    composable<Purchase> {
        PurchaseRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            navigateToProductDetail = navigateToProductDetail
        )
    }
}

@Serializable
data object Purchase : Route