package com.example.grocerystore.domain.repositories

import com.example.grocerystore.data.remote.request.LoginRequest
import com.example.grocerystore.data.remote.response.LoginResponse

interface UserRepository {
    suspend fun login(request: LoginRequest): LoginResponse
}