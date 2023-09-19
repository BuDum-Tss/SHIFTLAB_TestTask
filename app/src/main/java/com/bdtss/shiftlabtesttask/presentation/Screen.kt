package com.bdtss.shiftlabtesttask.presentation

sealed class Screen(val route: String) {
    object RegistrationScreen : Screen("registration_screen")
}