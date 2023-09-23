package com.bdtss.shiftlabtesttask.data.storage

import android.annotation.SuppressLint
import android.content.Context
import com.bdtss.shiftlabtesttask.domain.model.UserData
import java.text.SimpleDateFormat
import java.util.*

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val SHARED_NAME_KEY = "firstName"
private const val SHARED_SURNAME_KEY = "surname"
private const val SHARED_BIRTH_DATE_KEY = "birthDate"
private const val SHARED_PASSWORD_KEY = "password"

class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    override fun save(userData: UserData) {
        sharedPreferences.edit().putString(SHARED_NAME_KEY, userData.name)
        sharedPreferences.edit().putString(SHARED_SURNAME_KEY, userData.surname)
        sharedPreferences.edit().putString(SHARED_BIRTH_DATE_KEY, userData.birthDate.toString())
        sharedPreferences.edit().putString(SHARED_PASSWORD_KEY, userData.password)
        println("All saved")
    }

    @SuppressLint("SimpleDateFormat")
    override fun get(): UserData {
        val name = sharedPreferences.getString(SHARED_NAME_KEY, "") ?: ""
        val surname = sharedPreferences.getString(SHARED_SURNAME_KEY, "") ?: ""
        val birthDateStr = sharedPreferences.getString(SHARED_BIRTH_DATE_KEY, "") ?: ""
        val password = sharedPreferences.getString(SHARED_PASSWORD_KEY, "") ?: ""
        val birthDate = SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr)
        println("All returned")
        return UserData(
            name = name,
            surname = surname,
            birthDate = birthDate as Date,
            password = password
        )
    }
}