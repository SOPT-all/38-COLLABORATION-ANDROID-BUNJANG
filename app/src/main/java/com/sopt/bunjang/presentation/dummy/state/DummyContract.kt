package com.sopt.bunjang.presentation.dummy.state

import androidx.compose.runtime.Immutable
import com.sopt.bunjang.core.util.UiState
import com.sopt.bunjang.presentation.dummy.model.DummyUiModel
import kotlinx.collections.immutable.PersistentList

@Immutable
data class DummyState(
    val dummyList: UiState<PersistentList<DummyUiModel>> = UiState.Empty,
    val isLoading: Boolean = false
)

sealed interface DummySideEffect {
    data class ShowErrorMessage(val msg: String) : DummySideEffect
}