package com.sopt.bunjang.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bunjang.R
import com.sopt.bunjang.core.designsystem.component.topbar.BunjangTopBar
import com.sopt.bunjang.core.designsystem.component.topbar.TopBarIconButton
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.presentation.home.component.HomeLogo
import com.sopt.bunjang.presentation.home.state.HomeSideEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToProductDetail: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.sideEffect.collectLatest { effect ->
            when (effect) {
                is HomeSideEffect.NavigateToProductDetail -> navigateToProductDetail()
            }
        }
    }

    HomeScreen(
        paddingValues = paddingValues,
        onProductItemClick = viewModel::onProductItemClick
    )
}

@Composable
private fun HomeScreen(
    paddingValues: PaddingValues,
    onProductItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        BunjangTopBar(
            leftContent = { HomeLogo() },
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

        LazyColumn(

        ) {
            item {

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    BunjangTheme{
        HomeScreen(
            paddingValues = PaddingValues(),
            onProductItemClick = {}
        )
    }
}