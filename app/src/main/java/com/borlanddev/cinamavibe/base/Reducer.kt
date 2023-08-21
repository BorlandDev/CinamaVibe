package com.borlanddev.cinamavibe.base

abstract class Reducer<T : UiState, E : UiEvent> {
    abstract fun reduce(state: T, event: E): T
}