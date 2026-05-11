package com.sopt.bunjang.data.dummy.remote.datasource

import com.sopt.bunjang.data.dummy.remote.dto.response.DummyResponseDto
import com.sopt.bunjang.core.network.model.BaseResponse


interface DummyDataSource {
    suspend fun getDummyList(): BaseResponse<List<DummyResponseDto>>
}