package com.sopt.bunjang.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bunjang.data.home.repository.HomeRepository
import com.sopt.bunjang.presentation.home.state.HomeSideEffect
import com.sopt.bunjang.presentation.home.state.HomeUiState
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
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    private val _sideEffect = MutableSharedFlow<HomeSideEffect>()
    val sideEffect: SharedFlow<HomeSideEffect> = _sideEffect.asSharedFlow()
    private val _uiState = MutableStateFlow(HomeUiState.dummy)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        getHome()
    }

    private fun getHome() {
        viewModelScope.launch {
            homeRepository.getHome(userId = 1L)
                .onSuccess { homeModel ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            glassesProducts = homeModel.glassesProducts.toImmutableList(),
                            similarProducts = homeModel.similarProducts.toImmutableList(),
                            kidultProducts = homeModel.kidultProducts.toImmutableList(),
                            userName = homeModel.userName,
                            productCount = homeModel.productCount
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update { currentState ->
                        currentState.copy(errorMessage = throwable.message ?: "홈 화면 조회가 실패했습니다.")
                    }
                }
        }
    }

    fun onProductItemClick(id: Long) {
        viewModelScope.launch {
            _sideEffect.emit(HomeSideEffect.NavigateToProductDetail(id))
        }
    }

    fun onLikeClick(productId: Long) {
        viewModelScope.launch {
            homeRepository.toggleLike(productId = productId, userId = 1L)
                .onSuccess { likeData ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            glassesProducts = currentState.glassesProducts.map { product ->
                                if (product.id == likeData.productId) {
                                    product.copy(isLike = likeData.isLiked, likes = likeData.likeCount)
                                } else product
                            }.toImmutableList()
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update { currentState ->
                        currentState.copy(errorMessage = throwable.message ?: "찜 상태 변경이 실패했습니다.")
                    }
                }
        }
    }
}