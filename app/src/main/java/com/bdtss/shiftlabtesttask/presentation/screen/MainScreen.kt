package com.bdtss.shiftlabtesttask.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bdtss.shiftlabtesttask.presentation.viewmodel.MainViewModel


@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        Button(
            onClick = {
                Log.e("AAA", "Greeting button pushed")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Greeting")
        }
    }

}