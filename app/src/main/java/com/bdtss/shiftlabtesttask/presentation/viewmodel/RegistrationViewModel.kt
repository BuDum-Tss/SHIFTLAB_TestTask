package com.bdtss.shiftlabtesttask.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bdtss.shiftlabtesttask.domain.model.RegistrationData
import com.bdtss.shiftlabtesttask.domain.usecase.RegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*

class RegistrationViewModel(private val registerUseCase: RegisterUseCase) : ViewModel() {
    private val _name = MutableStateFlow("")
    private val _surname = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _passwordConfirmation = MutableStateFlow("")
    val name = _name.asStateFlow()
    var surname = _surname.asStateFlow()
    var password = _password.asStateFlow()
    var passwordConfirmation = _passwordConfirmation.asStateFlow()

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
            Log.e("AAA", "Register success")
        }
    }

    fun setName(name: String) {
        _name.value = name
    }

    fun setSurname(surname: String) {
        _surname.value = surname
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setPasswordConfirmation(passwordConfirmation: String) {
        _passwordConfirmation.value = passwordConfirmation
    }
}