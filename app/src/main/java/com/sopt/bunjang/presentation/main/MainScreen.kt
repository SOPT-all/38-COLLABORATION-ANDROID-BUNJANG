package com.sopt.bunjang.presentation.main

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import com.sopt.bunjang.presentation.chat.navigation.chatGraph
import com.sopt.bunjang.presentation.dummy.navigation.dummyGraph
import com.sopt.bunjang.presentation.favorite.navigation.favoriteGraph
import com.sopt.bunjang.presentation.home.navigation.homeGraph
import com.sopt.bunjang.presentation.main.component.MainBottomBar
import com.sopt.bunjang.presentation.mypage.navigation.myPageGraph
import com.sopt.bunjang.presentation.productdetail.navigation.productDetailGraph
import com.sopt.bunjang.presentation.purchase.navigation.purchaseGraph
import com.sopt.bunjang.presentation.register.navigation.registerGraph
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    appState: MainAppState = rememberMainAppState(),
) {
    val isBottomBarVisible by appState.isBottomBarVisible.collectAsStateWithLifecycle()
    val currentTab by appState.currentTab.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            MainBottomBar(
                isVisible = isBottomBarVisible,
                tabs = MainTab.entries.toPersistentList(),
                currentTab = currentTab,
                onTabSelected = appState::navigate
            )
        },
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding()
    ) { innerPadding ->
        NavHost(
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> -fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 300)
                )
            },
            navController = appState.navController,
            startDestination = appState.startDestination
        ) {
            dummyGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            homeGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp,
                navigateToProductDetail = appState::navigateToProductDetail
            )

            favoriteGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            registerGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            chatGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            myPageGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp
            )

            productDetailGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp,
                navigateToHome = appState::navigateToHome,
                navigateToPurchase = appState::navigateToPurchase
            )

            purchaseGraph(
                paddingValues = innerPadding,
                navigateUp = appState::navigateUp,
                navigateToProductDetail = appState::navigateToProductDetail
            )
        }
    }
}
