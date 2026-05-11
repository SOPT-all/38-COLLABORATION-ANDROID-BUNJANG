package com.sopt.bunjang.presentation.dummy.model

import com.sopt.bunjang.data.dummy.model.DummyModel

data class DummyUiModel(
    val id: Int,
    val profileUrl: String,
    val fullName: String
)

fun DummyModel.toUiModel(): DummyUiModel {
    return DummyUiModel(
        id = id,
        profileUrl = profile,
        fullName = "$firstName $lastName"
    )
}