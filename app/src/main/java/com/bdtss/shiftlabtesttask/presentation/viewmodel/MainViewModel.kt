package com.bdtss.shiftlabtesttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.bdtss.shiftlabtesttask.domain.usecase.GetGreetingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(private val greetingUseCase: GetGreetingUseCase) : ViewModel() {
    private val _alertDialogIsOpened = MutableStateFlow(false)
    val alertDialogIsOpened = _alertDialogIsOpened.asStateFlow()
    fun getGreeting(): String {
        return greetingUseCase.execute()
    }

    fun setAlertDialogVisible(visibility: Boolean) {
        _alertDialogIsOpened.value = visibility
    }
}