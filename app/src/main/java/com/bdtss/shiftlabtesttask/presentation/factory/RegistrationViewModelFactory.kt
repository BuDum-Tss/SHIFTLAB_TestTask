package com.bdtss.shiftlabtesttask.presentation.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bdtss.shiftlabtesttask.data.repository.UserRepositoryImpl
import com.bdtss.shiftlabtesttask.data.storage.SharedPrefUserStorage
import com.bdtss.shiftlabtesttask.domain.repository.UserRepository
import com.bdtss.shiftlabtesttask.domain.usecase.RegisterUseCase
import com.bdtss.shiftlabtesttask.presentation.viewmodel.RegistrationViewModel

class RegistrationViewModelFactory(userRepository: UserRepository) : ViewModelProvider.Factory {

    private val registerUseCase by lazy(LazyThreadSafetyMode.NONE) {
        RegisterUseCase(userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegistrationViewModel(registerUseCase) as T
    }
}