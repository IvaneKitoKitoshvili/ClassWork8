package com.example.classwork8.ui.useCases

import com.example.classwork8.base.BaseUseCase
import com.example.classwork8.data.models.ItemsData
import com.example.classwork8.other.ResponseHandler
import kotlinx.coroutines.flow.Flow

interface GetItemsUseCases : BaseUseCase<Unit, Flow<ResponseHandler<ItemsData>>> {
    override suspend fun invoke(params: Unit): Flow<ResponseHandler<ItemsData>>
}