package com.borlanddev.cinamavibe.ui.login.usecase

import com.borlanddev.cinamavibe.base.BaseUseCase
import com.borlanddev.cinamavibe.ui.login.LoginEvent
import com.borlanddev.cinamavibe.ui.login.LoginResult

class RegistrationUseCase : BaseUseCase<LoginEvent>() {

    override fun canExecute(event: LoginEvent): Boolean = event is LoginEvent.Registration

    override suspend fun <LoginState> execute(state: LoginState, event: LoginEvent): LoginEvent {
        return if (event is LoginEvent.Registration) {
            // TODO("Not yet impl")
            LoginEvent.Result(LoginResult.SUCCESS)
        } else LoginEvent.Empty
    }
}