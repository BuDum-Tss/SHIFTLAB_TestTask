package com.bdtss.shiftlabtesttask.data.storage

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.SimpleDateFormat
import com.bdtss.shiftlabtesttask.domain.model.UserData
import java.util.*

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_NAME = "firstName"
private const val KEY_SURNAME = "surname"
private const val KEY_BIRTH_DATE = "birthDate"
private const val KEY_PASSWORD = "password"

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    init {
        println("storage init")
    }

    @SuppressLint("CommitPrefEdits")
    override fun save(userData: UserData) {
        sharedPreferences
            .edit()
            .putString(KEY_NAME, userData.name)
            .putString(KEY_SURNAME, userData.surname)
            .putString(KEY_BIRTH_DATE, SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(userData.birthDate))
            .putString(KEY_PASSWORD, userData.password)
            .apply()
    }

    @SuppressLint("SimpleDateFormat")
    override fun get(): UserData {
        val name = sharedPreferences.getString(KEY_NAME, "") ?: KEY_NAME
        val surname = sharedPreferences.getString(KEY_SURNAME, "") ?: KEY_SURNAME
        val birthDateStr = sharedPreferences.getString(KEY_BIRTH_DATE, "") ?: KEY_BIRTH_DATE
        val password = sharedPreferences.getString(KEY_PASSWORD, "") ?: KEY_PASSWORD
        val birthDate = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).parse(birthDateStr)
        return UserData(
            name = name,
            surname = surname,
            birthDate = birthDate,
            password = password
        )
    }
}