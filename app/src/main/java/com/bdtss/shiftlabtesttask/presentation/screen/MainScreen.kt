package com.bdtss.shiftlabtesttask.presentation.screen

import android.util.Log
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bdtss.shiftlabtesttask.presentation.viewmodel.MainViewModel


@Composable
fun MainScreen(
    mainViewModel: MainViewModel
) {
    val alertDialogIsOpened = mainViewModel.alertDialogIsOpened.collectAsState()
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        Button(
            onClick = {
                mainViewModel.setAlertDialogVisible(true)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Greeting")
        }
        if (alertDialogIsOpened.value) {
            AlertDialog(
                title = { Text(text = mainViewModel.getGreeting()) },
                text = { Text(text = mainViewModel.getGreeting()) },
                onDismissRequest = { mainViewModel.setAlertDialogVisible(false) },
                confirmButton = {
                    TextButton(
                        onClick = {
                            mainViewModel.setAlertDialogVisible(false)
                        }) {
                        Text("Confirm")
                    }
                }
            )
        }
    }

}