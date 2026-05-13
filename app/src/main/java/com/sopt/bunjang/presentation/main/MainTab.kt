package com.sopt.bunjang.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sopt.bunjang.R
import com.sopt.bunjang.core.navigation.MainTabRoute
import com.sopt.bunjang.core.navigation.Route
import com.sopt.bunjang.presentation.chat.navigation.Chat
import com.sopt.bunjang.presentation.favorite.navigation.Favorite
import com.sopt.bunjang.presentation.home.navigation.Home
import com.sopt.bunjang.presentation.mypage.navigation.MyPage
import com.sopt.bunjang.presentation.register.navigation.Register

enum class MainTab(
    @param:DrawableRes val icon: Int,
    @param:StringRes val contentDescription: Int,
    val route: MainTabRoute,
) {
    HOME(
        icon = R.drawable.ic_home_home,
        contentDescription = R.string.tab_home,
        route = Home,
    ),
    FAVORITE(
        icon = R.drawable.ic_home_like,
        contentDescription = R.string.tab_favorite,
        route = Favorite,
    ),
    REGISTER(
        icon = R.drawable.ic_home_post,
        contentDescription = R.string.tab_register,
        route = Register,
    ),
    CHAT(
        icon = R.drawable.ic_home_talk,
        contentDescription = R.string.tab_chat,
        route = Chat,
    ),
    MY_PAGE(
        icon = R.drawable.ic_home_my,
        contentDescription = R.string.tab_my_page,
        route = MyPage,
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}