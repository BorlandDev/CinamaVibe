package com.borlanddev.cinamavibe.ui.login

import com.borlanddev.cinamavibe.base.Reducer

class LoginReducer : Reducer<LoginState, LoginEvent>() {
    override fun reduce(state: LoginState, event: LoginEvent): LoginState {
        return when (event) {
            is LoginEvent.Email -> {
                state.copy(email = event.text)
            }

            is LoginEvent.Password -> {
                state.copy(password = event.text)
            }

            is LoginEvent.Registration -> {
                state.copy(isLoading = true)
            }

            is LoginEvent.Login -> {
                state.copy(isLoading = true)
            }

            is LoginEvent.Result -> {
                state.copy(isLoading = false)
                if (event.result == LoginResult.SUCCESS) {
                    state.copy(isRegistered = true)
                } else {
                    state.copy(errorMessage = "Something wrong")
                }
            }

            else -> {
                state
            }
        }
    }
}