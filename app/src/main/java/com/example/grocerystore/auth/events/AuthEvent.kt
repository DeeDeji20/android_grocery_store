package com.example.grocerystore.auth.events

sealed class AuthEvent{
    data class Login(
        val email: String,
        val password: String
    ): AuthEvent()

    object LoginSuccess: AuthEvent()
}
