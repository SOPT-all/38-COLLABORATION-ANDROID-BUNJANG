package com.sopt.bunjang.presentation.register.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.bunjang.core.navigation.MainTabRoute
import com.sopt.bunjang.presentation.register.RegisterRoute
import kotlinx.serialization.Serializable

fun NavController.navigateRegister(navOptions: NavOptions? = null) {
    navigate(Register, navOptions)
}

fun NavGraphBuilder.registerGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Register> {
        RegisterRoute()
    }
}

@Serializable
data object Register : MainTabRoute