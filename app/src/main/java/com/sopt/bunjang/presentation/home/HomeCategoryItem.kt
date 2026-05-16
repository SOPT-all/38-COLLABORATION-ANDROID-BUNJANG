package com.sopt.bunjang.presentation.home

import androidx.annotation.DrawableRes
import com.sopt.bunjang.R

enum class CategoryItem(
    @param:DrawableRes val iconRes: Int,
    val label: String
) {
    MENU(R.drawable.ic_home_category_menu, "전체메뉴"),
    LIKES(R.drawable.ic_home_category_likes, "찜"),
    RECENT(R.drawable.ic_home_category_recent, "최근본상품"),
    PURCHASE(R.drawable.ic_home_category_purchase, "매입/위탁"),
    MISSION(R.drawable.img_home_category_mission, "미션혜택"),
    LOTTO(R.drawable.ic_home_category_lotto, "번개복권"),
    FEED(R.drawable.ic_home_category_feed, "관심피드"),
    PHONE(R.drawable.ic_home_category_phone, "내폰시세"),
    FLOWER(R.drawable.ic_home_category_flower, "꽃피우고\n모바일콘"),
    SAMSUNGCARD(R.drawable.ic_home_category_samsungcard, "번개장터\n삼성카드"),
    TISSOT(R.drawable.img_home_category_tissot, "티쏘"),
    KIDULT(R.drawable.img_home_category_kidult, "키덜트"),
    ALDEN(R.drawable.img_home_category_alden, "알든"),
    STONEISLAND(R.drawable.img_home_category_stoneisland, "스톤아일랜드"),
}