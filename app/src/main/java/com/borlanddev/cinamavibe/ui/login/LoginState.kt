package com.borlanddev.cinamavibe.ui.login

import com.borlanddev.cinamavibe.base.UiState

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isRegistered: Boolean = false,
    val isValidData: Boolean = true,
    val errorMessage: String = "",
) : UiState()
