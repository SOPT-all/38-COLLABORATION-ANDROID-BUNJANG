package com.sopt.bunjang.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme

enum class CategoryItem(
    @DrawableRes val iconRes: Int,
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
    FLOWER(R.drawable.ic_home_category_flower, "꽃피우고모바일콘"),
    SAMSUNGCARD(R.drawable.ic_home_category_samsungcard, "번개장터삼성카드"),
    TISSOT(R.drawable.img_home_category_tissot, "티쏘"),
    KIDULT(R.drawable.img_home_category_kidult, "키덜트"),
    ALDEN(R.drawable.img_home_category_alden, "알든"),
    STONEISLAND(R.drawable.img_home_category_stoneisland, "스톤아일랜드"),

}

@Composable
fun HomeCategoryItem(
    item: CategoryItem,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(color = BunjangTheme.colors.gray100, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = item.iconRes),
                contentDescription = item.label,
                modifier = Modifier.size(30.dp),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.label,
            style = BunjangTheme.typography.body.body4,
            color = BunjangTheme.colors.gray800,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun HomeCategoryAll(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(CategoryItem.entries) { item ->
            HomeCategoryItem(item = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeCategoryAll() {
    BunjangTheme {
        HomeCategoryAll()
    }
}