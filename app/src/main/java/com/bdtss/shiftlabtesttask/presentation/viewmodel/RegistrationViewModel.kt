package com.bdtss.shiftlabtesttask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.bdtss.shiftlabtesttask.domain.model.RegistrationData
import com.bdtss.shiftlabtesttask.domain.usecase.RegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*

class RegistrationViewModel(private val registerUseCase: RegisterUseCase) : ViewModel() {
    private val _name = MutableStateFlow("")
    private val _surname = MutableStateFlow("")
    private val _birthDate = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _passwordIsVisible = MutableStateFlow(false)
    private val _passwordConfirmation = MutableStateFlow("")
    private val _passwordConfirmationIsVisible = MutableStateFlow(false)
    private val _registrationIsSuccessful = MutableStateFlow(false)
    val name = _name.asStateFlow()
    var surname = _surname.asStateFlow()
    val birthDate = _birthDate.asStateFlow()
    var password = _password.asStateFlow()
    var passwordIsVisible = _passwordIsVisible.asStateFlow()
    var passwordConfirmation = _passwordConfirmation.asStateFlow()
    var passwordConfirmationIsVisible = _passwordConfirmationIsVisible.asStateFlow()
    var registrationIsSuccessful = _registrationIsSuccessful.asStateFlow()
    fun register() {
        val registrationData = RegistrationData(
            name = name.value,
            surname = surname.value,
            birthDate = birthDate.value,
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
    fun setBirthDate(birthDate: String) {
        _birthDate.value=birthDate
    }

    fun setPassword(password: String) {
        _password.value = password
    }
    fun setPasswordVisible(visibility: Boolean) {
        _passwordIsVisible.value = visibility
    }

    fun setPasswordConfirmation(passwordConfirmation: String) {
        _passwordConfirmation.value = passwordConfirmation
    }

    fun setPasswordConfirmationVisible(visibility: Boolean) {
        _passwordConfirmationIsVisible.value = visibility
    }

}