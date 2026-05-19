package com.sopt.bunjang.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bunjang.presentation.home.state.HomeSideEffect
import com.sopt.bunjang.presentation.home.state.HomeUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _sideEffect = MutableSharedFlow<HomeSideEffect>()
    val sideEffect: SharedFlow<HomeSideEffect> = _sideEffect.asSharedFlow()

    private val _uiState = MutableStateFlow(HomeUiState.dummy)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onProductItemClick(id: Long) {
        viewModelScope.launch {
            _sideEffect.emit(HomeSideEffect.NavigateToProductDetail(id))
        }
    }
}