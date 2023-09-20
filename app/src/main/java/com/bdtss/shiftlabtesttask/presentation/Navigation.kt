package com.bdtss.shiftlabtesttask.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(registrationViewModel: RegistrationViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.RegistrationScreen.route) {
        composable(route = Screen.RegistrationScreen.route) {
            RegistrationScreen(navController = navController, registrationViewModel)
        }
    }
}