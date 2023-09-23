package com.bdtss.shiftlabtesttask.domain.repository

import com.bdtss.shiftlabtesttask.domain.model.UserData

interface UserRepository {
    fun getUserData(): UserData
    fun saveUserData(userData: UserData)
}