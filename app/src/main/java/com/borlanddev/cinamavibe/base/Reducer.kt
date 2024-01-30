package com.borlanddev.cinamavibe.base

abstract class Reducer<T : UiState, E : UiEvent>(initState: T) {

    abstract fun reduce(state: T, event: E): T

    abstract fun getInitState(): T
}