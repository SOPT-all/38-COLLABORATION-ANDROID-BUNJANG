package com.sopt.bunjang.data.dummy.repositoryimpl

import com.sopt.bunjang.data.dummy.remote.datasource.DummyDataSource
import com.sopt.bunjang.data.dummy.model.DummyModel
import com.sopt.bunjang.data.dummy.repository.DummyRepository
import com.sopt.bunjang.core.util.suspendRunCatching
import com.sopt.bunjang.data.dummy.mapper.toModel
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyDataSource: DummyDataSource
) : DummyRepository {
    override suspend fun getDummyList(): Result<List<DummyModel>> = suspendRunCatching {
        dummyDataSource.getDummyList().data!!.map { it.toModel() }
    }
}

