package com.sopt.bunjang.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.sopt.bunjang.presentation.chat.navigation.navigateChat
import com.sopt.bunjang.presentation.favorite.navigation.navigateFavorite
import com.sopt.bunjang.presentation.home.navigation.Home
import com.sopt.bunjang.presentation.home.navigation.navigateHome
import com.sopt.bunjang.presentation.mypage.navigation.navigateMyPage
import com.sopt.bunjang.presentation.productdetail.navigation.navigateProductDetail
import com.sopt.bunjang.presentation.purchase.navigation.navigatePurchase
import com.sopt.bunjang.presentation.register.navigation.navigateRegister
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Stable
class MainAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val startDestination = Home

    private val currentDestination = navController.currentBackStackEntryFlow
        .map { it.destination }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null
        )

    val currentTab: StateFlow<MainTab?> = currentDestination
        .map { destination ->
            MainTab.find { tab ->
                destination?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    val isBottomBarVisible: StateFlow<Boolean> = currentDestination
        .map { destination ->
            MainTab.contains { tab ->
                destination?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                    saveState = true
                }
                restoreState = true
                launchSingleTop = true
            }
        }

        when (tab) {
            MainTab.HOME -> navController.navigateHome(navOptions)
            MainTab.FAVORITE -> navController.navigateFavorite(navOptions)
            MainTab.REGISTER -> navController.navigateRegister(navOptions)
            MainTab.CHAT -> navController.navigateChat(navOptions)
            MainTab.MY_PAGE -> navController.navigateMyPage(navOptions)
        }
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateToHome() {
        navController.navigateHome(clearStackNavOptions)
    }

    fun navigateToPurchase() {
        navController.navigatePurchase()
    }

    fun navigateToProductDetail(productId: Long) {
        navController.navigateProductDetail(productId)
    }

    private val clearStackNavOptions = navOptions {
        popUpTo(0) {
            inclusive = true
        }
        launchSingleTop = true
    }

}

@Composable
fun rememberMainAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): MainAppState = remember(navController,coroutineScope) {
    MainAppState(
        navController,
        coroutineScope,
    )
}