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
    private val _registrationIsSuccessful = MutableStateFlow(false)
    val name = _name.asStateFlow()
    var surname = _surname.asStateFlow()
    var password = _password.asStateFlow()
    var passwordConfirmation = _passwordConfirmation.asStateFlow()
    var registrationIsSuccessful = _registrationIsSuccessful.asStateFlow()


    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun register() {
        val registrationData: RegistrationData = RegistrationData(
            name = name.value,
            surname = surname.value,
            birthDate = Date(1), //TODO:change
            password = password.value,
            passwordConfirmation = passwordConfirmation.value
        );
        _registrationIsSuccessful.value = registerUseCase.execute(registrationData)
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