package com.sopt.bunjang.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bunjang.data.home.repository.HomeRepository
import com.sopt.bunjang.presentation.home.state.HomeSideEffect
import com.sopt.bunjang.presentation.home.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.collections.immutable.toImmutableList
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
            homeRepository.getHome(userId = 1L) // 임시로 1L
                .onSuccess { glassesProducts ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            glassesProducts = glassesProducts.toImmutableList()
                        )
                    }
                }
                .onFailure {
                    // 에러 처리
                }
        }
    }

    fun onProductItemClick(id: Long) {
        viewModelScope.launch {
            _sideEffect.emit(HomeSideEffect.NavigateToProductDetail(id))
        }
    }
}