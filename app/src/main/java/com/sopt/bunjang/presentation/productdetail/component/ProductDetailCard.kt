package com.sopt.bunjang.presentation.productdetail.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.core.extension.noRippleClickable
import com.sopt.bunjang.presentation.productdetail.model.ProductDetailCardUiModel
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ProductDetailCard(
    uiModel: ProductDetailCardUiModel,
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState(pageCount = { uiModel.imageUrls.size }),
    isLike: Boolean = false,
    onLikeClick: () -> Unit = {}
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(BunjangTheme.colors.white)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(361f / 360f)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                AsyncImage(
                    model = uiModel.imageUrls[page],
                    contentDescription = "Product Image ${page + 1}",
                    placeholder = ColorPainter(Color.LightGray),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            } //이미지

            DetailPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier.align(Alignment.TopEnd)
            ) //이미지 페이지 표시
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 19.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = uiModel.title,
                    style = BunjangTheme.typography.title.title4
                ) //상품명

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "%,d".format(uiModel.price) + "원",
                    style = BunjangTheme.typography.title.title1
                ) //가격
            }

            Icon(
                painter = painterResource(
                    id = if (isLike) R.drawable.ic_heart_filled_39 else R.drawable.ic_heart_outlined_39
                ),
                contentDescription = "like",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(39.dp)
                    .noRippleClickable { onLikeClick() }
            ) //찜
        }

        Spacer(modifier = Modifier.height(16.dp))

        MakeOfferButton(
            text = "가격제안",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 19.dp)
        ) //가격제안 버튼

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 19.dp)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            uiModel.time?.let {
                Text(
                    text = it,
                    style = BunjangTheme.typography.body.body3,
                    color = BunjangTheme.colors.gray300,
                )
            } //시간

            Spacer(modifier = Modifier.weight(1f))

            uiModel.views?.let { count ->
                StatItem(
                    iconRes = R.drawable.ic_detail_page_view,
                    count = count,
                    contentDescription = "views"
                )
            } //조회수

            Spacer(modifier = Modifier.width(6.dp))

            uiModel.likes?.let { count ->
                StatItem(
                    iconRes = R.drawable.ic_detail_page_heart,
                    count = count,
                    contentDescription = "likes"
                )
            } //찜 수

            Spacer(modifier = Modifier.width(6.dp))

            uiModel.comments?.let { count ->
                StatItem(
                    iconRes = R.drawable.ic_detail_page_comment,
                    count = count,
                    contentDescription = "comments"
                )
            } //댓글 수
        }
    }
}

@Composable
private fun DetailPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val currentPage = pagerState.currentPage + 1
    val totalPages = pagerState.pageCount

    Text(
        text = "$currentPage/$totalPages",
        color = BunjangTheme.colors.white,
        style = BunjangTheme.typography.body.body2_1,
        modifier = modifier
            .padding(horizontal = 13.dp, vertical = 15.dp)
            .background(
                color = BunjangTheme.colors.gray500_70,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 9.dp, vertical = 3.dp)
    )
}

@Composable
private fun StatItem(
    @DrawableRes iconRes: Int,
    count: Int,
    contentDescription: String,
) {
    Icon(
        painter = painterResource(id = iconRes),
        contentDescription = contentDescription,
        tint = BunjangTheme.colors.gray300,
        modifier = Modifier.size(12.dp)
    )

    Spacer(modifier = Modifier.width(2.dp))

    Text(
        text = count.toString(),
        style = BunjangTheme.typography.body.body3,
        color = BunjangTheme.colors.gray300
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailCardPreview() {
    BunjangTheme {
        ProductDetailCard(
            uiModel = ProductDetailCardUiModel(
                id = 1,
                imageUrls = listOf("", "").toImmutableList(),
                price = 210000,
                title = "이펙터 코러스 GLCY",
                time = "4일 전",
                views = 148,
                likes = 7,
                comments = 0
            ),
        )
    }
}

