package com.sopt.bunjang.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailSideEffect
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel : ViewModel() {
    private val _sideEffect = MutableSharedFlow<ProductDetailSideEffect>()
    val sideEffect: SharedFlow<ProductDetailSideEffect> = _sideEffect.asSharedFlow()

    private val _uiState = MutableStateFlow(ProductDetailUiState())
    val uiState: StateFlow<ProductDetailUiState> = _uiState.asStateFlow()

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
}