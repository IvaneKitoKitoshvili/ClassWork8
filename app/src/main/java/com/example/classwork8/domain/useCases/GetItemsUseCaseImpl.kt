package com.example.classwork8.domain.useCases

import com.example.classwork8.domain.repository.ItemsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetItemsUseCaseImpl @Inject constructor(private val coursesRepository: ItemsRepository) :
    GetItemsData {
    override suspend fun invoke(params: Unit) = flow {
        emit(coursesRepository.getCourses())
    }
}