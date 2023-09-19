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
import java.lang.ref.Reference
import java.lang.reflect.TypeVariable
import java.util.*

@Composable
fun RegistrationScreen(navController: NavController, registrationViewModel: RegistrationViewModel) {
    var name by remember {
        mutableStateOf("")
    }
    var surname by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var passwordConfirmation by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldCard(
            text = "Name:",
            name,
            onValueChange = { name = it })
        TextFieldCard(
            text = "Surname:",
            surname,
            onValueChange = { surname = it })
        TextFieldCard(
            text = "Password:",
            password,
            onValueChange = { password = it })
        TextFieldCard(
            text = "Please, repeat password:",
            passwordConfirmation,
            onValueChange = { passwordConfirmation = it })
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                Log.e("AAA", "Register button pushed")
                registrationViewModel.register(
                    name,
                    surname,
                    Date(1),
                    password,
                    passwordConfirmation
                )
                //TODO: navController.navigate(mainScreen...)
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
