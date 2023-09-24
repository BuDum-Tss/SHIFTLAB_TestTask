package com.bdtss.shiftlabtesttask.presentation.screen

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bdtss.shiftlabtesttask.presentation.Screen
import com.bdtss.shiftlabtesttask.presentation.viewmodel.RegistrationViewModel
import com.bdtss.shiftlabtesttask.ui.theme.Purple500
import com.bdtss.shiftlabtesttask.ui.theme.Purple700
import java.util.*

@Composable
fun RegistrationScreen(
    navController: NavController,
    registrationViewModel: RegistrationViewModel,
    context: Context
) {
    val name = registrationViewModel.name.collectAsState()
    val surname = registrationViewModel.surname.collectAsState()
    val birthDate = registrationViewModel.birthDate.collectAsState()
    val password = registrationViewModel.password.collectAsState()
    val passwordConfirmation = registrationViewModel.passwordConfirmation.collectAsState()
    val passwordIsVisible = registrationViewModel.passwordIsVisible.collectAsState()
    val passwordConfirmationIsVisible =
        registrationViewModel.passwordConfirmationIsVisible.collectAsState()
    val errorMessage = registrationViewModel.errorMessage.collectAsState()
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Register",
            fontSize = 30.sp,
            color = Purple700,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start)
        )
        TextFieldCard(
            labelText = "Name",
            placeholderText = "Enter your name",
            value = name.value,
            onValueChange = { registrationViewModel.setName(it) }
        )
        TextFieldCard(
            labelText = "Surname",
            placeholderText = "Enter your surname",
            surname.value
        ) { registrationViewModel.setSurname(it) }
        DateFieldCard(
            labelText = "Birth date",
            placeholderText = "Enter the date",
            value = birthDate.value.toString(),
            onValueChange = { registrationViewModel.setBirthDate(it) },
            context = context
        )
        PasswordFieldCard(
            labelText = "Password",
            placeholderText = "Enter the password",
            value = password.value,
            onValueChange = { registrationViewModel.setPassword(it) },
            showPassword = passwordIsVisible.value,
            onClickIcon = { registrationViewModel.setPasswordVisible(!passwordIsVisible.value) }
        )
        PasswordFieldCard(
            labelText = "Password confirmation",
            placeholderText = "Please, repeat the password",
            value = passwordConfirmation.value,
            onValueChange = { registrationViewModel.setPasswordConfirmation(it) },
            showPassword = passwordConfirmationIsVisible.value,
            onClickIcon = { registrationViewModel.setPasswordConfirmationVisible(!passwordConfirmationIsVisible.value) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                registrationViewModel.register()
                if (registrationViewModel.registrationIsSuccessful.value) {
                    navController.navigate(Screen.MainScreen.route)
                }
            },
            enabled = name.value != "" && surname.value!="" && birthDate.value !="" && password.value != "" && passwordConfirmation.value != "",
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Register")
        }
        if (errorMessage.value != "") {
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(corner = CornerSize(size = 30f)))
                    .border(
                        width = 2.dp,
                        color = Purple500,
                        shape = RoundedCornerShape(corner = CornerSize(size = 30f))
                    )
            ) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = errorMessage.value,
                    color = Purple700,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
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
        keyboardOptions = KeyboardOptions(KeyboardCapitalization.Words),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PasswordFieldCard(
    labelText: String,
    placeholderText: String,
    value: String,
    onValueChange: (String) -> Unit,
    showPassword: Boolean,
    onClickIcon: () -> Unit
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun DateFieldCard(
    labelText: String,
    placeholderText: String,
    value: String,
    onValueChange: (String) -> Unit,
    context: Context
) {
    Spacer(modifier = Modifier.height(8.dp))
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = labelText) },
        placeholder = { Text(text = placeholderText) },
        trailingIcon = {
            IconButton(onClick = {
                val c = Calendar.getInstance()
                val currentYear = c.get(Calendar.YEAR)
                val currentMonth = c.get(Calendar.MONTH)
                val currentDay = c.get(Calendar.DAY_OF_MONTH)
                val dpd = DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        onValueChange("$day.$month.$year")
                    },
                    currentYear,
                    currentMonth,
                    currentDay
                )
                dpd.show()
            }) {
                Icon(
                    imageVector = Icons.Outlined.DateRange,
                    contentDescription = "Select a date"
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}
