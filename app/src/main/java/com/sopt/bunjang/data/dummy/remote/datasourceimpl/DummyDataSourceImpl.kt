package com.sopt.bunjang.data.dummy.remote.datasourceimpl

import com.sopt.bunjang.core.network.model.BaseResponse
import com.sopt.bunjang.data.dummy.remote.api.DummyService
import com.sopt.bunjang.data.dummy.remote.datasource.DummyDataSource
import com.sopt.bunjang.data.dummy.remote.dto.response.DummyResponseDto
import javax.inject.Inject

class DummyDataSourceImpl @Inject constructor(
    private val dummyService: DummyService,
) : DummyDataSource {
    override suspend fun getDummyList(): BaseResponse<List<DummyResponseDto>> =
        dummyService.getDummyLists()
}