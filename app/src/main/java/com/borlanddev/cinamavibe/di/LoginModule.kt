package com.borlanddev.cinamavibe.di

import com.borlanddev.cinamavibe.ui.login.LoginReducer
import com.borlanddev.cinamavibe.ui.login.LoginViewModel
import com.borlanddev.cinamavibe.ui.login.usecase.LoginUseCase
import com.borlanddev.cinamavibe.ui.login.usecase.RegistrationUseCase
import com.borlanddev.cinamavibe.ui.login.usecase.SocialNetworkUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    factory { LoginReducer() }
    factory { LoginUseCase() }
    factory { RegistrationUseCase() }
    factory { SocialNetworkUseCase() }

    viewModel {
        LoginViewModel(get(), get(), get(), get())
    }
}