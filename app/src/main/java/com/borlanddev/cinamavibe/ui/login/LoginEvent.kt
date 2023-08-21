package com.borlanddev.cinamavibe.ui.login

import com.borlanddev.cinamavibe.base.UiEvent

sealed class LoginEvent : UiEvent() {
    data class Email(val text: String) : LoginEvent()
    data class Password(val text: String) : LoginEvent()
    data class Login(val email: String, val password: String) : LoginEvent()
    data class Registration(val email: String, val password: String) : LoginEvent()
    data class Result(val result: LoginResult) : LoginEvent()
    data object RegistrationWithSocialNetwork : LoginEvent()
    data object Empty : LoginEvent()

    // data object FieldFocusChange: LoginEvent() , for validate for each text field
}

enum class LoginResult(
    val message: String
) {
    SUCCESS("You`ve login"),
    FAILURE("Something wrong")
}




