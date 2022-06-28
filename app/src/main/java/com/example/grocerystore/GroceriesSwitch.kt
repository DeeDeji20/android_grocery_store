package com.example.grocerystore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.grocerystore.auth.AuthenticationWrapper
import com.example.grocerystore.auth.viewModels.AuthViewModel


@Composable
fun GroceriesSwitch(
    authViewModel: AuthViewModel = hiltViewModel()
){
    val isAuthentication = false

    if (isAuthentication){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Text(text = "Welcome")
        }
    }else{
        AuthenticationWrapper(
            viewModel = authViewModel
        )
    }
}