package com.bdtss.shiftlabtesttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.bdtss.shiftlabtesttask.domain.usecase.GetGreetingUseCase

class MainViewModel(private val greetingUseCase: GetGreetingUseCase) : ViewModel() {
    fun getGreeting(): String {
        return greetingUseCase.execute()
    }
}