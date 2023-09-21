package com.bdtss.shiftlabtesttask.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bdtss.shiftlabtesttask.presentation.screen.MainScreen
import com.bdtss.shiftlabtesttask.presentation.viewmodel.MainViewModel
import com.bdtss.shiftlabtesttask.presentation.viewmodel.RegistrationViewModel

@Composable
fun Navigation(registrationViewModel: RegistrationViewModel, mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.RegistrationScreen.route
    ) {
        composable(route = Screen.RegistrationScreen.route) {
            RegistrationScreen(
                navController = navController,
                registrationViewModel = registrationViewModel
            )
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
    }
}