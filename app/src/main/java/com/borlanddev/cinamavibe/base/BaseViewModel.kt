package com.borlanddev.cinamavibe.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T : UiState, E : UiEvent>(
    private val reducer: Reducer<T, E>,
    private val usecases: List<BaseUseCase<E>>
) : ViewModel() {

    abstract val state: MutableStateFlow<T>
    protected fun sendEvent(event: E) {
        state.value = reducer.reduce(state.value, event)

        val correlatedUsecases = usecases.filter {
            it.canExecute(event)
        }

        correlatedUsecases.forEach {
            viewModelScope.launch {
                state.value = reducer.reduce(state.value, it.execute(state.value, event))
            }
        }
    }
}