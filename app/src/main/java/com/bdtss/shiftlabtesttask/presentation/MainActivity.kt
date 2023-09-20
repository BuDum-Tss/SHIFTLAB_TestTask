package com.bdtss.shiftlabtesttask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.bdtss.shiftlabtesttask.presentation.factory.RegistrationViewModelFactory
import com.bdtss.shiftlabtesttask.presentation.viewmodel.RegistrationViewModel

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
