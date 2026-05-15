package com.sopt.bunjang.presentation.purchase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bunjang.presentation.purchase.model.PurchaseProductItem
import com.sopt.bunjang.presentation.purchase.state.PurchaseSideEffect
import com.sopt.bunjang.presentation.purchase.state.PurchaseUiState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PurchaseViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PurchaseUiState.dummy)
    val uiState: StateFlow<PurchaseUiState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<PurchaseSideEffect>()
    val sideEffect: SharedFlow<PurchaseSideEffect> = _sideEffect.asSharedFlow()

    fun onProductClick(product: PurchaseProductItem) {
        viewModelScope.launch {
            _sideEffect.emit(PurchaseSideEffect.NavigateToProductDetail(product.id))
        }
    }

    fun onLikeClick(product: PurchaseProductItem) {
        _uiState.update { state ->
            state.copy(
                recommendProducts = state.recommendProducts.map {
                    if (it.id == product.id) it.copy(isLike = !it.isLike) else it
                }.toImmutableList()
            )
        }
    }
}