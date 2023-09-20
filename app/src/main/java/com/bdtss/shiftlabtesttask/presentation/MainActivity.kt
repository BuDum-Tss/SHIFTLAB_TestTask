package com.bdtss.shiftlabtesttask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    private lateinit var vm: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        vm = ViewModelProvider(
            this,
            RegistrationViewModelFactory()
        ).get(RegistrationViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(vm)
        }

    }
}
