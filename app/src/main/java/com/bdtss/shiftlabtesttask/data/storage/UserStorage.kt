package com.bdtss.shiftlabtesttask.data.storage

import com.bdtss.shiftlabtesttask.domain.model.UserData

interface UserStorage {
    fun save(userData: UserData)
    fun get(): UserData
}