package com.bdtss.shiftlabtesttask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bdtss.shiftlabtesttask.domain.usecase.RegisterUseCase

class RegistrationViewModelFactory : ViewModelProvider.Factory {
    private val registerUseCase by lazy(LazyThreadSafetyMode.NONE) {
        RegisterUseCase()
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegistrationViewModel(registerUseCase) as T
    }
}