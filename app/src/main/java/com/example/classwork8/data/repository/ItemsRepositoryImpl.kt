package com.example.classwork8.data.repository

import com.example.classwork8.data.api.ItemsApi
import com.example.classwork8.data.models.ItemsData
import com.example.classwork8.domain.repository.ItemsRepository
import com.example.classwork8.extensions.toModel
import com.example.classwork8.other.ResponseHandler
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(private val coursesApi: ItemsApi) :
    ItemsRepository {
    override suspend fun getCourses(): ResponseHandler<ItemsData> {
        return try {
            val result = coursesApi.getItems()
            when {
                result.isSuccessful -> {
                    val body = result.body()
                    ResponseHandler.Success(body?.toModel())
                }
                else -> {
                    val errorMsg = result.errorBody()?.string()
                    ResponseHandler.Error(errorMsg)
                }
            }
        } catch (e: Exception) {
            ResponseHandler.Error("Unexpected error occurred")
        }
    }
}