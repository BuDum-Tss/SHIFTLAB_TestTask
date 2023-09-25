package com.bdtss.shiftlabtesttask.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bdtss.shiftlabtesttask.domain.repository.UserRepository
import com.bdtss.shiftlabtesttask.domain.usecase.GetGreetingUseCase
import com.bdtss.shiftlabtesttask.presentation.viewmodel.MainViewModel

class MainViewModelFactory(userRepository: UserRepository) : ViewModelProvider.Factory {
    private val getGreetingUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetGreetingUseCase(userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getGreetingUseCase) as T
    }
}