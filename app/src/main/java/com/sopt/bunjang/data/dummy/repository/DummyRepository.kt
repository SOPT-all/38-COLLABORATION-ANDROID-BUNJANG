package com.sopt.bunjang.data.dummy.repository

import com.sopt.bunjang.data.dummy.model.DummyModel

interface DummyRepository {
    suspend fun getDummyList(): Result<List<DummyModel>>
}