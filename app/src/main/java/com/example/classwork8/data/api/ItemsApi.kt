package com.example.classwork8.data.api

import com.example.classwork8.constants.COURSES_END_POINT
import com.example.classwork8.data.models.ItemsData
import retrofit2.Response
import retrofit2.http.GET

interface ItemsApi {

    @GET(COURSES_END_POINT)
    suspend fun getItems(): Response<ItemsData>

}