package com.sopt.bunjang.data.dummy.remote.api

import com.sopt.bunjang.core.network.model.BaseResponse
import com.sopt.bunjang.data.dummy.remote.dto.response.DummyResponseDto
import retrofit2.http.GET
import retrofit2.http.Query


interface DummyService {
    @GET("api/users")
    suspend fun getDummyLists(
        @Query("page") page: Int = 2,
    ): BaseResponse<List<DummyResponseDto>>
}