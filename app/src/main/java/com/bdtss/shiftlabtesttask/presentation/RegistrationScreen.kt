package com.bdtss.shiftlabtesttask.presentation;

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.util.*

@Composable
fun RegistrationScreen(
    navController: NavController,
    registrationViewModel: RegistrationViewModel
) {
    val name = registrationViewModel.name.collectAsState()
    var surname = registrationViewModel.surname.collectAsState()
    var password = registrationViewModel.password.collectAsState()
    var passwordConfirmation = registrationViewModel.passwordConfirmation.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        TextFieldCard(
            text = "Name:",
            value = name.value
        ) { registrationViewModel.setName(it) }
        TextFieldCard(
            text = "Surname:",
            surname.value
        ) { registrationViewModel.setSurname(it) }
        TextFieldCard(
            text = "Password:",
            password.value
        ) { registrationViewModel.setPassword(it) }
        TextFieldCard(
            text = "Please, repeat password:",
            passwordConfirmation.value
        ) { registrationViewModel.setPasswordConfirmation(it) }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                Log.e("AAA", "Register button pushed")
                registrationViewModel.register(
                    name.value,
                    surname.value,
                    Date(1),
                    password.value,
                    passwordConfirmation.value
                )
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Register")
        }
    }
}

@Composable
fun TextFieldCard(text: String, value: String, onValueChange: (String) -> Unit) {
    Text(text = text)
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier =
        Modifier.fillMaxWidth()
    )
}
