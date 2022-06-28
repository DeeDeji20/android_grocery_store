package com.example.grocerystore.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grocerystore.auth.screens.Login
import com.example.grocerystore.auth.screens.Register
import com.example.grocerystore.auth.viewModels.AuthViewModel
import com.example.grocerystore.navigation.destinations.Destination

@Composable
fun AuthenticationNavigationHost(
    navController: NavHostController,
    authViewModel: AuthViewModel
){

    NavHost(navController = navController, startDestination = Destination.LoginDestination.route  ){

        composable(route= Destination.LoginDestination.route){
            Login(navController = navController,
                    authViewModel= authViewModel
            )
        }

        composable(route= Destination.SignupDestination.route){
            Register(navController = navController)
        }
    }
}