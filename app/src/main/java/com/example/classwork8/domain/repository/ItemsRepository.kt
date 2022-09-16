package com.example.classwork8.domain.repository

import com.example.classwork8.other.ResponseHandler

interface ItemsRepository {
    suspend fun getCourses(): ResponseHandler<ItemsModel>
}