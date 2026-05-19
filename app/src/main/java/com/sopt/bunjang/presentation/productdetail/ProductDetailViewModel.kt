package com.sopt.bunjang.presentation.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.sopt.bunjang.data.product.repository.ProductRepository
import com.sopt.bunjang.presentation.productdetail.navigation.ProductDetail
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailBottomUiState
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailSideEffect
import com.sopt.bunjang.presentation.productdetail.state.ProductDetailTopUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val productId: Long = savedStateHandle.toRoute<ProductDetail>().productId
    private val userId: Long = 1L
    private val _topUiState = MutableStateFlow(ProductDetailTopUiState.dummy)
    val topUiState: StateFlow<ProductDetailTopUiState> = _topUiState.asStateFlow()

    private val _bottomUiState = MutableStateFlow(ProductDetailBottomUiState.dummy)
    val bottomUiState: StateFlow<ProductDetailBottomUiState> = _bottomUiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<ProductDetailSideEffect>()
    val sideEffect: SharedFlow<ProductDetailSideEffect> = _sideEffect.asSharedFlow()

    fun onLikeClick() {
        _topUiState.value = _topUiState.value.copy(isLike = !_topUiState.value.isLike)
    }

    fun onFollowClick() {
        _topUiState.value = _topUiState.value.copy(isFollowing = !_topUiState.value.isFollowing)
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
        _bottomUiState.update { state ->
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