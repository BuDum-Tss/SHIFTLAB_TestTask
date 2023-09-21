package com.bdtss.shiftlabtesttask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.bdtss.shiftlabtesttask.presentation.factory.MainViewModelFactory
import com.bdtss.shiftlabtesttask.presentation.factory.RegistrationViewModelFactory
import com.bdtss.shiftlabtesttask.presentation.viewmodel.MainViewModel
import com.bdtss.shiftlabtesttask.presentation.viewmodel.RegistrationViewModel

class MainActivity : ComponentActivity() {
    private lateinit var vm: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        val registrationViewModel = ViewModelProvider(
            this,
            RegistrationViewModelFactory()
        ).get(RegistrationViewModel::class.java)
        val mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory()
        ).get(MainViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(
                registrationViewModel = registrationViewModel,
                mainViewModel = mainViewModel
            )
        }

    }
}
