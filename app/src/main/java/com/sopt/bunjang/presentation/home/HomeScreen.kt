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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    navigateToProductDetail: (Long) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { effect ->
            when (effect) {
                is HomeSideEffect.NavigateToProductDetail -> navigateToProductDetail(effect.id)
                is HomeSideEffect.ShowSnackBar -> snackBarHostState.showSnackbar(effect.message)
            }
        }
    }

    HomeScreen(
        paddingValues = paddingValues,
        uiState = uiState,
        onProductItemClick = viewModel::onProductItemClick,
        onLikeClick = viewModel::onLikeClick,
        snackBarHostState = snackBarHostState
    )
}

@Composable
private fun HomeScreen(
    paddingValues: PaddingValues,
    onProductItemClick: (Long) -> Unit,
    onLikeClick: (Long) -> Unit,
    uiState: HomeUiState,
    snackBarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(innerPadding)
                .background(color = BunjangTheme.colors.white)
        ) {
            BunjangTopBar(
                leftContent = { HomeMainToggle() },
                rightContent = {
                    TopBarIconButton(
                        iconRes = R.drawable.ic_top_bar_search,
                        // Todo: 상품 아이템 구현 후, 아이템 클릭 시 동작으로 이동 필요
                        onClick = {}
                    )
                    TopBarIconButton(iconRes = R.drawable.ic_top_bar_bell)
                    TopBarIconButton(iconRes = R.drawable.ic_top_bar_cart)
                }
            )

            LazyColumn(modifier = Modifier.weight(1f)) {
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
                        userName = uiState.userName,
                        productCount = uiState.productCount,
                        onProductClick = onProductItemClick,
                        onLikeClick = onLikeClick
                    )
                }
                item {

                    Spacer(modifier = Modifier.height(24.dp))
                    HomeRecentProduct(
                        modifier = Modifier.fillMaxSize(),
                        homeRecentProductList = uiState.similarProducts,
                        onLikeClick = onLikeClick
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
                        homeKidultList = uiState.kidultProducts,
                        onLikeClick = onLikeClick
                    )
                    Spacer(modifier = Modifier.height(21.dp))
                }
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
            onProductItemClick = { _ -> },
            onLikeClick = { _ -> },
            uiState = HomeUiState.dummy,
            snackBarHostState = remember { SnackbarHostState() }
        )
    }
}