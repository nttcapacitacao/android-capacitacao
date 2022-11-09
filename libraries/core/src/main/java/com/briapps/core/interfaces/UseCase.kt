package com.briapps.core.interfaces

interface UseCase<T, in param> {
    suspend fun execute(params: param): T
}

interface SimpleUseCase<T> {
    suspend fun execute(): T
}