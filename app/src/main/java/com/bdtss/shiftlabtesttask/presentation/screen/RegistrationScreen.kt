package com.bdtss.shiftlabtesttask.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bdtss.shiftlabtesttask.presentation.Screen
import com.bdtss.shiftlabtesttask.presentation.viewmodel.RegistrationViewModel
import com.bdtss.shiftlabtesttask.ui.theme.Purple700

@Composable
fun RegistrationScreen(
    navController: NavController,
    registrationViewModel: RegistrationViewModel
) {
    val name = registrationViewModel.name.collectAsState()
    val surname = registrationViewModel.surname.collectAsState()
    val password = registrationViewModel.password.collectAsState()
    val passwordConfirmation = registrationViewModel.passwordConfirmation.collectAsState()
    val passwordIsVisible = registrationViewModel.passwordIsVisible.collectAsState()
    val passwordConfirmationIsVisible = registrationViewModel.passwordConfirmationIsVisible.collectAsState()
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Register",
            fontSize = 30.sp,
            color = Purple700,
            modifier = Modifier.fillMaxWidth().align(Alignment.Start)
        )
        TextFieldCard(
            labelText ="Name",
            placeholderText = "Enter your name",
            value = name.value,
            onValueChange = { registrationViewModel.setName(it) }
        )
        TextFieldCard(
            labelText ="Surname",
            placeholderText = "Enter your surname",
            surname.value
        ) { registrationViewModel.setSurname(it) }
        PasswordFieldCard(
            labelText = "Password",
            placeholderText = "Enter the password",
            value = password.value,
            onValueChange = { registrationViewModel.setPassword(it) },
            showPassword = passwordIsVisible.value,
            onClickIcon = { registrationViewModel.setPasswordVisible(!passwordIsVisible.value)}
        )
        PasswordFieldCard(
            labelText = "Password confirmation",
            placeholderText = "Please, repeat the password",
            value = passwordConfirmation.value,
            onValueChange = { registrationViewModel.setPasswordConfirmation(it) },
            showPassword = passwordConfirmationIsVisible.value,
            onClickIcon = { registrationViewModel.setPasswordConfirmationVisible(!passwordConfirmationIsVisible.value)}
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                registrationViewModel.register()
                if (registrationViewModel.registrationIsSuccessful.value) {
                    navController.navigate(Screen.MainScreen.route)
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Register")
        }
    }
}
@Composable
fun TextFieldCard(
    labelText: String,
    placeholderText: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Spacer(modifier = Modifier.height(8.dp))
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText) },
        placeholder = { Text(text = placeholderText) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordFieldCard(
    labelText: String,
    placeholderText: String,
    value: String,
    onValueChange: (String) -> Unit,
    showPassword : Boolean,
    onClickIcon: ()->Unit
) {
    Spacer(modifier = Modifier.height(8.dp))
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText) },
        placeholder = { Text(text = placeholderText) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Lock,
                contentDescription = "Lock Icon"
            )
        },
        trailingIcon = {
            IconButton(onClick = onClickIcon) {
                Icon(
                    imageVector = if (showPassword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                    contentDescription = if (showPassword) "Show Password" else "Hide Password"
                )
            }
        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}