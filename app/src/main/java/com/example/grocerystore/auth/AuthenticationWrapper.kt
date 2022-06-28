package com.example.grocerystore.auth

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.grocerystore.auth.viewModels.AuthViewModel
import com.example.grocerystore.navigation.navHost.AuthenticationNavigationHost

@Composable
fun AuthenticationWrapper(
    viewModel: AuthViewModel
){
    val navController = rememberNavController()
    AuthenticationNavigationHost(navController = navController,
        authViewModel = viewModel)
}