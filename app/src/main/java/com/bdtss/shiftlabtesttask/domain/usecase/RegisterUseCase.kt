package com.bdtss.shiftlabtesttask.domain.usecase

import com.bdtss.shiftlabtesttask.domain.model.RegistrationData

class RegisterUseCase {
    fun execute(data: RegistrationData): Boolean {
        //TODO: add checks of data
        //TODO: hash passwords
        return data.password == data.passwordConfirmation
    }
}