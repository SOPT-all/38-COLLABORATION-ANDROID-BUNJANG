package com.sopt.bunjang.data.dummy.mapper

import com.sopt.bunjang.data.dummy.remote.dto.response.DummyResponseDto
import com.sopt.bunjang.data.dummy.model.DummyModel
import javax.inject.Inject

fun DummyResponseDto.toModel() = DummyModel(
    profile = avatar,
    firstName = firstName,
    id = id,
    lastName = lastName
)


