package com.sopt.bunjang.presentation.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.bunjang.core.util.UiState
import com.sopt.bunjang.data.dummy.repository.DummyRepository
import com.sopt.bunjang.presentation.dummy.model.toUiModel
import com.sopt.bunjang.presentation.dummy.state.DummySideEffect
import com.sopt.bunjang.presentation.dummy.state.DummyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
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
class DummyViewModel @Inject constructor(
    private val dummyRepository: DummyRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(DummyState())
    val uiState: StateFlow<DummyState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<DummySideEffect>()
    val sideEffect: SharedFlow<DummySideEffect> = _sideEffect.asSharedFlow()

    init {
        getInitDummyList()
    }

    fun getInitDummyList() {
        _uiState.update {
            it.copy(
                dummyList = UiState.Loading
            )
        }

        viewModelScope.launch {
            dummyRepository.getDummyList()
                .onSuccess { data ->
                    _uiState.update { state ->
                        state.copy(
                            dummyList = UiState.Success(
                                data.map { it.toUiModel() }.toPersistentList()
                            ),
                            isLoading = false
                        )
                    }
                }
                .onFailure { failure ->
                    _uiState.update {
                        it.copy(
                            dummyList = UiState.Failure(failure.message ?: ""),
                            isLoading = false
                        )
                    }
                    _sideEffect.emit(DummySideEffect.ShowErrorMessage(failure.message ?: "알 수 없는 에러가 발생했습니다."))
                }
        }
    }
}