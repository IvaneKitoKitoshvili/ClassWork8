package com.example.classwork8.di

import com.example.classwork8.domain.useCases.GetItemsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetCoursesUseCase(getCoursesUseCaseImpl: GetItemsUseCaseImpl): GetItemsUseCase
}