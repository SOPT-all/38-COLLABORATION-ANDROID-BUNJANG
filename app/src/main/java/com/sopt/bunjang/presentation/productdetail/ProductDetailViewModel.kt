package com.sopt.bunjang.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailSideEffect
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailUiState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProductDetailUiState.dummy)
    val uiState: StateFlow<ProductDetailUiState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<ProductDetailSideEffect>()
    val sideEffect: SharedFlow<ProductDetailSideEffect> = _sideEffect.asSharedFlow()

    fun onLikeClick() {
        _uiState.value = _uiState.value.copy(isLike = !_uiState.value.isLike)
    }

    fun onFollowClick() {
        _uiState.value = _uiState.value.copy(isFollowing = !_uiState.value.isFollowing)
    }

    fun onBackIconClick() {
        viewModelScope.launch {
            _sideEffect.emit(ProductDetailSideEffect.NavigateUp)
        }
    }

    fun onHomeIconClick() {
        viewModelScope.launch {
            _sideEffect.emit(ProductDetailSideEffect.NavigateToHome)
        }
    }

    fun onPurchaseIconClick() {
        viewModelScope.launch {
            _sideEffect.emit(ProductDetailSideEffect.NavigateToPurchase)
        }
    }

    fun onProductClick(id: Long) {
        viewModelScope.launch { _sideEffect.emit(ProductDetailSideEffect.NavigateToProductDetail(id)) }
    }

    fun onLikeClick(id: Long) {
        _uiState.update { state ->
            state.copy(
                recommendProducts = state.recommendProducts.map { product ->
                    if (product.id == id) product.copy(isLike = !product.isLike)
                    else product
                }.toImmutableList(),

                similarProducts = state.similarProducts.map { group ->
                    group.copy(
                        products = group.products.map { product ->
                            if (product.id == id) product.copy(isLike = !product.isLike)
                            else product
                        }.toImmutableList()
                    )
                }.toImmutableList()
            )
        }
    }
}