package com.sopt.bunjang.presentation.productdetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.bunjang.core.navigation.Route
import com.sopt.bunjang.presentation.productdetail.ProductDetailRoute
import kotlinx.serialization.Serializable

fun NavController.navigateProductDetail(navOptions: NavOptions? = null) {
    navigate(ProductDetail, navOptions)
}

fun NavGraphBuilder.productDetailGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToHome: () -> Unit,
    navigateToPurchase: () -> Unit
) {
    composable<ProductDetail> {
        ProductDetailRoute(
            paddingValues = paddingValues,
            navigateUp = navigateUp,
            navigateToHome = navigateToHome,
            navigateToPurchase = navigateToPurchase
        )
    }
}

@Serializable
data object ProductDetail : Route