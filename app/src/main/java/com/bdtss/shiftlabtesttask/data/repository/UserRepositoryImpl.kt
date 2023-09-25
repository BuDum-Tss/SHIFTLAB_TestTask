package com.bdtss.shiftlabtesttask.data.repository

import com.bdtss.shiftlabtesttask.data.storage.UserStorage
import com.bdtss.shiftlabtesttask.domain.model.UserData
import com.bdtss.shiftlabtesttask.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {
    init {
        println("repository init")
    }

    override fun getUserData(): UserData {
        return userStorage.get()
    }

    override fun saveUserData(userData: UserData) {
        userStorage.save(userData)
    }
}