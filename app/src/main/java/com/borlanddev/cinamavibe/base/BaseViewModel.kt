package com.borlanddev.cinamavibe.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<T : UiState, E : UiEvent>(
    private val reducer: Reducer<T, E>,
    private val usecases: List<BaseUseCase<E>>
) : ViewModel() {

    private val _state: MutableStateFlow<T> = MutableStateFlow(reducer.getInitState())
    val state: StateFlow<T> = _state.asStateFlow()
    protected fun sendEvent(event: E) {
        _state.value = reducer.reduce(_state.value, event)

        val correlatedUsecases = usecases.filter {
            it.canExecute(event)
        }

        correlatedUsecases.forEach {
            viewModelScope.launch {
                _state.value = reducer.reduce(_state.value, it.execute(_state.value, event))
            }
        }
    }
}