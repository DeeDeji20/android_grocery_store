package com.example.grocerystore.navigation.destinations

sealed class Destination(val name: String, val route: String){
    object LoginDestination: Destination(name = "Login", route="login")
    object SignupDestination: Destination(name = "Signup", route="signup")

}
