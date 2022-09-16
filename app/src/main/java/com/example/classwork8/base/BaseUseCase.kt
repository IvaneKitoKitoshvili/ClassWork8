package com.example.classwork8.base

interface BaseUseCase<Params, Result> {
     suspend operator fun invoke(params: Params): Result
}