package com.example.grocerystore.data.repositories

import com.example.grocerystore.data.remote.Api
import com.example.grocerystore.data.remote.request.LoginRequest
import com.example.grocerystore.data.remote.response.LoginResponse
import com.example.grocerystore.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val api: Api

): UserRepository {
    override suspend fun login(request: LoginRequest): LoginResponse {
        TODO("Not yet implemented")
    }
}