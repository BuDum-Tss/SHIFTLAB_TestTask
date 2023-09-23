package com.bdtss.shiftlabtesttask.domain.usecase

import com.bdtss.shiftlabtesttask.domain.model.RegistrationData
import com.bdtss.shiftlabtesttask.domain.model.UserData
import com.bdtss.shiftlabtesttask.domain.repository.UserRepository
import java.util.*

class RegisterUseCase(private val userRepository: UserRepository) {
    fun execute(data: RegistrationData): Boolean {
        //TODO: add checks of data
        //TODO: hash passwords
        //TODO: parse date
        val result = data.password == data.passwordConfirmation
        if (result) {
            userRepository.saveUserData(
                UserData(
                    data.name,
                    data.surname,
                    Date(),
                    data.password
                )
            )
            println("Data: "+data.name)
        }
        return result
    }
}