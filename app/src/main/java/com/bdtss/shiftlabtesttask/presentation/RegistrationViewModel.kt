package com.bdtss.shiftlabtesttask.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bdtss.shiftlabtesttask.domain.model.RegistrationData
import com.bdtss.shiftlabtesttask.domain.usecase.RegisterUseCase
import java.util.*

class RegistrationViewModel(private val registerUseCase: RegisterUseCase) : ViewModel() {
    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun register(
        name: String,
        surname: String,
        birthDate: Date,
        password: String,
        passwordConfirmation: String
    ) {
        val registrationData: RegistrationData = RegistrationData(
            name = name,
            surname = surname,
            birthDate = birthDate,
            password = password,
            passwordConfirmation = passwordConfirmation
        );
        if (registerUseCase.execute(registrationData)) {
            Log.e("AAA","Register success")
        }
    }
}