package com.borlanddev.cinamavibe.ui.login

import com.borlanddev.cinamavibe.base.BaseViewModel
import com.borlanddev.cinamavibe.ui.login.LoginEvent.ChangeEmail
import com.borlanddev.cinamavibe.ui.login.LoginEvent.Login
import com.borlanddev.cinamavibe.ui.login.LoginEvent.ChangePassword
import com.borlanddev.cinamavibe.ui.login.LoginEvent.Registration
import com.borlanddev.cinamavibe.ui.login.usecase.LoginUseCase
import com.borlanddev.cinamavibe.ui.login.usecase.RegistrationUseCase
import com.borlanddev.cinamavibe.ui.login.usecase.SocialNetworkUseCase

class LoginViewModel(
    loginReducer: LoginReducer,
    loginUseCase: LoginUseCase,
    registrationUseCase: RegistrationUseCase,
    socialNetworkUseCase: SocialNetworkUseCase,
) : BaseViewModel<LoginState, LoginEvent>(
    loginReducer,
    listOf(
        loginUseCase,
        registrationUseCase,
        socialNetworkUseCase
    )
) {
    fun changeEmail(text: String) {
        sendEvent(ChangeEmail(text))
    }

    fun changePassword(text: String) {
        sendEvent(ChangePassword(text))
    }

    fun login() {
        if (state.value.isRegistered) sendEvent(Login(state.value.email, state.value.password))
        else sendEvent(Registration(state.value.email, state.value.password))
    }

    private fun validatingField(): Boolean = state.value.email.isNotEmpty()

    /*  private fun validateInput(inputValue: String, inputType: InputType): Boolean =
          when (inputType) {
              InputType.EMAIL -> {
                  !TextUtils.isEmpty(inputValue) && android.util.Patterns.EMAIL_ADDRESS.matcher(
                      inputValue
                  ).matches()
              }

              InputType.PASSWORD -> {
                  !TextUtils.isEmpty(inputValue) && inputValue.length > 5

              }
          }*/
}