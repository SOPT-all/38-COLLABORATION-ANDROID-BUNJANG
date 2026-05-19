package com.sopt.bunjang.presentation.purchase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.bunjang.core.designsystem.theme.BunjangTheme
import com.sopt.bunjang.presentation.purchase.component.PurchaseConfirmButton
import com.sopt.bunjang.presentation.purchase.component.PurchaseNoticeCard
import com.sopt.bunjang.presentation.purchase.component.PurchaseRecommendSection
import com.sopt.bunjang.presentation.purchase.component.PurchaseSuccessMessage
import com.sopt.bunjang.presentation.purchase.model.PurchaseProductItem
import com.sopt.bunjang.presentation.purchase.state.PurchaseSideEffect
import com.sopt.bunjang.presentation.purchase.state.PurchaseUiState

@Composable
fun PurchaseRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToProductDetail: (Long) -> Unit,
    viewModel: PurchaseViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is PurchaseSideEffect.NavigateToProductDetail -> navigateToProductDetail(sideEffect.id)
            }
        }
    }

    PurchaseScreen(
        paddingValues = paddingValues,
        uiState = uiState,
        onProductClick = viewModel::onProductClick,
        onLikeClick = viewModel::onLikeClick,
    )
}

@Composable
private fun PurchaseScreen(
    paddingValues: PaddingValues,
    uiState: PurchaseUiState,
    onProductClick: (PurchaseProductItem) -> Unit,
    onLikeClick: (PurchaseProductItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PurchaseNoticeCard(
                userName = uiState.userName,
                productName = uiState.productName,
                time = uiState.noticeTime,
                modifier = Modifier
                    .padding(top = 3.dp)
                    .padding(horizontal = 19.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            PurchaseSuccessMessage()

            Spacer(modifier = Modifier.weight(2f))

            PurchaseRecommendSection(
                products = uiState.recommendProducts,
                onProductClick = onProductClick,
                onLikeClick = onLikeClick,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(BunjangTheme.colors.white)
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = BunjangTheme.colors.gray100
            )

            PurchaseConfirmButton(
                modifier = Modifier.padding(horizontal = 19.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PurchaseScreenPreview() {
    BunjangTheme {
        PurchaseScreen(
            paddingValues = PaddingValues(),
            uiState = PurchaseUiState.dummy,
            onProductClick = {},
            onLikeClick = {},
        )
    }
}