package com.bdtss.shiftlabtesttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bdtss.shiftlabtesttask.domain.usecase.RegisterUseCase
import com.bdtss.shiftlabtesttask.presentation.Navigation
import com.bdtss.shiftlabtesttask.presentation.RegistrationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(RegistrationViewModel(RegisterUseCase()))
        }
    }
}