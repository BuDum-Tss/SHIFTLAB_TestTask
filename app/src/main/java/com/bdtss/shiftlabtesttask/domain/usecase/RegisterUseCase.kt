package com.bdtss.shiftlabtesttask.domain.usecase

import com.bdtss.shiftlabtesttask.domain.model.RegistrationData
import com.bdtss.shiftlabtesttask.domain.model.UserData
import com.bdtss.shiftlabtesttask.domain.repository.UserRepository

class RegisterUseCase(private val userRepository: UserRepository) {
    fun execute(data: RegistrationData): Boolean {
        //TODO: add checks of data
        //TODO: hash passwords
        val result = data.password == data.passwordConfirmation
        if (result) {
            userRepository.saveUserData(
                UserData(
                    data.name,
                    data.surname,
                    data.birthDate,
                    data.password
                )
            )
            println("Data: "+data.name)
        }
        return result
    }
}