package com.example.classwork8.di

import com.example.classwork8.data.repository.ItemsRepositoryImpl
import com.example.classwork8.domain.repository.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(coursesRepositoryImpl: ItemsRepositoryImpl): ItemsRepository
}
