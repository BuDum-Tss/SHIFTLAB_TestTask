package com.bdtss.shiftlabtesttask.domain.usecase

import android.icu.text.SimpleDateFormat
import com.bdtss.shiftlabtesttask.domain.model.RegistrationData
import com.bdtss.shiftlabtesttask.domain.model.RegistrationResult
import com.bdtss.shiftlabtesttask.domain.model.UserData
import com.bdtss.shiftlabtesttask.domain.repository.UserRepository
import java.text.ParseException
import java.util.*

class RegisterUseCase(private val userRepository: UserRepository) {
    fun execute(data: RegistrationData): RegistrationResult {
        val nameIsValid = checkName(data.name)
        if (!nameIsValid) return RegistrationResult(
            false,
            "The name must consist only of Latin characters and contain more than 1 characters"
        )
        val surnameIsValid = checkSurname(data.surname)
        if (!surnameIsValid) return RegistrationResult(
            false,
            "The surname must consist only of Latin characters and contain more than 2 characters"
        )
        val date = parseDate(data.birthDate)
            ?: return RegistrationResult(
                false,
                "The date should be in the format:\"dd.MM.yyyy\""
            )
        val passwordIsValid = checkPassword(data.password)
        if (!passwordIsValid) return RegistrationResult(
            false,
            "The password must contain at least 1 uppercase and 1 lowercase Latin letter, a number and a special sign"
        )
        if (data.password != data.passwordConfirmation) return RegistrationResult(false, "Passwords don't match")
        userRepository.saveUserData(
            UserData(
                data.name,
                data.surname,
                date,
                data.password
            )
        )
        return RegistrationResult(true, "")
    }

    private fun checkName(text: String): Boolean {
        return text.length > 1 && !(text.contains(regex = Regex("[^a-zA-Z]")))
    }

    private fun checkSurname(text: String): Boolean {
        return text.length > 2 && !(text.contains(regex = Regex("[^a-zA-Z]")))
    }

    private fun parseDate(text: String): Date? {
        val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val date: Date? = try {
            formatter.parse(text)
        } catch (e: ParseException) {
            null
        }
        return date
    }

    private fun checkPassword(text: String): Boolean {
        return text.length > 6 &&
                text.contains(regex = Regex("[a-z]")) &&
                text.contains(regex = Regex("[A-Z]")) &&
                text.contains(regex = Regex("[0-9]")) &&
                text.contains(regex = Regex("[!#%^{}:|]"))
    }
}
