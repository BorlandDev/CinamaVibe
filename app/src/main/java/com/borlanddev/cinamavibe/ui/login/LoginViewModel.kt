package com.borlanddev.cinamavibe.ui.login

import com.borlanddev.cinamavibe.base.BaseViewModel
import com.borlanddev.cinamavibe.ui.login.LoginEvent.Email
import com.borlanddev.cinamavibe.ui.login.LoginEvent.Login
import com.borlanddev.cinamavibe.ui.login.LoginEvent.Password
import com.borlanddev.cinamavibe.ui.login.LoginEvent.Registration
import com.borlanddev.cinamavibe.ui.login.usecase.LoginUseCase
import com.borlanddev.cinamavibe.ui.login.usecase.RegistrationUseCase
import com.borlanddev.cinamavibe.ui.login.usecase.SocialNetworkUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

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

    override val state = MutableStateFlow(LoginState())
    val loginState = this.state.asStateFlow()

    fun emailInput(text: String) {
        sendEvent(Email(text))
    }

    fun passwordInput(text: String) {
        sendEvent(Password(text))
    }

    fun registration() {
        sendEvent(Registration(state.value.email, state.value.password))
    }

    fun login() {
        sendEvent(Login(state.value.email, state.value.password))
    }


    private fun validationField(): Boolean = state.value.email.isNotEmpty()

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