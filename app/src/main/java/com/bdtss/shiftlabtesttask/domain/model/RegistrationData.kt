package com.bdtss.shiftlabtesttask.domain.model

import java.util.*

class RegistrationData(
    val name: String,
    val surname: String,
    val birthDate: Date,
    val password: String,
    val passwordConfirmation: String
) {
}