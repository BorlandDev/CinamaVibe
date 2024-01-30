package com.borlanddev.cinamavibe.ui.login

import com.borlanddev.cinamavibe.base.Reducer

class LoginReducer(private val initState: LoginState) : Reducer<LoginState, LoginEvent>(initState) {
    override fun getInitState(): LoginState = initState
    override fun reduce(state: LoginState, event: LoginEvent): LoginState {
        return when (event) {
            is LoginEvent.ChangeEmail -> {
                state.copy(email = event.text)
            }

            is LoginEvent.ChangePassword -> {
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

            is LoginEvent.Empty -> state
            is LoginEvent.RegistrationWithSocialNetwork -> TODO()
        }
    }
}