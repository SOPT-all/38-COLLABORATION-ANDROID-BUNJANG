package com.sopt.bunjang.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.component.topbar.BunjangTopBar
import com.sopt.bunjang.core.designsystem.component.topbar.TopBarIconButton
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.presentation.home.component.HomeCategoryAll
import com.sopt.bunjang.presentation.home.component.HomeGlassesSection
import com.sopt.bunjang.presentation.home.component.HomeKidultSection
import com.sopt.bunjang.presentation.home.component.HomeMainToggle
import com.sopt.bunjang.presentation.home.component.HomeRecentProduct
import com.sopt.bunjang.presentation.home.component.HomeTabBar
import com.sopt.bunjang.presentation.home.state.HomeSideEffect
import com.sopt.bunjang.presentation.home.state.HomeUiState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToProductDetail: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { effect ->
            when (effect) {
                is HomeSideEffect.NavigateToProductDetail -> navigateToProductDetail()
            }
        }
    }

    HomeScreen(
        paddingValues = paddingValues,
        uiState = uiState,
        onProductItemClick = viewModel::onProductItemClick
    )
}

@Composable
private fun HomeScreen(
    paddingValues: PaddingValues,
    onProductItemClick: () -> Unit,
    uiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = BunjangTheme.colors.white)
    ) {
        BunjangTopBar(
            leftContent = { HomeMainToggle() },
            rightContent = {
                TopBarIconButton(
                    iconRes = R.drawable.ic_top_bar_search,
                    // Todo: 상품 아이템 구현 후, 아이템 클릭 시 동작으로 이동 필요
                    onClick = onProductItemClick
                )
                TopBarIconButton(iconRes = R.drawable.ic_top_bar_bell)
                TopBarIconButton(iconRes = R.drawable.ic_top_bar_cart)
            }
        )

        LazyColumn {
            item {
                HomeTabBar(modifier = Modifier.fillMaxWidth())
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.img_home_banner),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(360f / 131f),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                HomeCategoryAll()
            }
            item {
                Image(
                    painter = painterResource(id = R.drawable.img_home_interest),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 17.dp)
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .aspectRatio(327f / 106f),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                HomeGlassesSection(
                    modifier = Modifier.fillMaxWidth(),
                    homeProductList = uiState.glassesProducts,
                    onProductClick = onProductItemClick
                )
            }
            item {

                Spacer(modifier = Modifier.height(24.dp))
                HomeRecentProduct(
                    modifier = Modifier.fillMaxSize(),
                    homeRecentProductList = uiState.similarProducts
                )
            }
            item {
                Spacer(modifier = Modifier.height(11.dp))
                Image(
                    painter = painterResource(id = R.drawable.img_baseball_festa),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(361f / 624f),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                HomeKidultSection(
                    modifier = Modifier.fillMaxWidth(),
                    homeKidultList = uiState.kidultProducts
                )
                Spacer(modifier = Modifier.height(21.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    BunjangTheme {
        HomeScreen(
            paddingValues = PaddingValues(),
            onProductItemClick = {},
            uiState = HomeUiState.dummy
        )
    }
}