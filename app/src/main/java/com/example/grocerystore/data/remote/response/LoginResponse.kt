package com.example.grocerystore.data.remote.response

import com.example.grocerystore.data.remote.models.User

data class LoginResponse(
    val status: String,
    val token: String,
    val data: User
)
