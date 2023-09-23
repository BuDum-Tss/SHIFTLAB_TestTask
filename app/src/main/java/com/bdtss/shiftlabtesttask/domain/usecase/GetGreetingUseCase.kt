package com.bdtss.shiftlabtesttask.domain.usecase;

import com.bdtss.shiftlabtesttask.domain.repository.UserRepository

class GetGreetingUseCase(private val userRepository: UserRepository) {
    fun execute(): String {
        return "Hello, " + userRepository.getUserData().name
    }
}
