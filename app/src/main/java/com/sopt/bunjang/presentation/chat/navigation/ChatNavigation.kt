package com.sopt.bunjang.presentation.chat.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.bunjang.core.navigation.MainTabRoute
import com.sopt.bunjang.presentation.chat.ChatRoute
import kotlinx.serialization.Serializable

fun NavController.navigateChat(navOptions: NavOptions? = null) {
    navigate(Chat, navOptions)
}

fun NavGraphBuilder.chatGraph(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit
) {
    composable<Chat> {
        ChatRoute()
    }
}

@Serializable
data object Chat : MainTabRoute