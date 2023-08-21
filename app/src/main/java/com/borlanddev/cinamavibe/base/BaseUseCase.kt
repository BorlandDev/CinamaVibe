package com.borlanddev.cinamavibe.base

abstract class BaseUseCase<E : UiEvent> {
    abstract fun canExecute(event: E): Boolean

    abstract suspend fun <T> execute(state: T, event: E): E

}