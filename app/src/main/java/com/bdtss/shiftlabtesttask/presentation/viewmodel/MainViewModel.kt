package com.bdtss.shiftlabtesttask.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bdtss.shiftlabtesttask.domain.usecase.GetGreetingUseCase

class MainViewModel(private val greetingUseCase: GetGreetingUseCase) : ViewModel() {
    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

}