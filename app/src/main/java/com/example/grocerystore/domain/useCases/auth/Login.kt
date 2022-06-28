package com.example.grocerystore.domain.useCases.auth

import com.example.grocerystore.data.remote.request.LoginRequest
import com.example.grocerystore.data.remote.response.LoginResponse
import com.example.grocerystore.domain.repositories.UserRepository
import com.example.grocerystore.general.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import java.lang.Exception

class Login(
    private val userRepository: UserRepository

) {
    operator fun invoke(request: LoginRequest): Flow<Resource<LoginResponse>> =


        flow{
            try {
                emit(Resource.Loading<LoginResponse>())
                var response= userRepository.login(request)
                emit(Resource.Success<LoginResponse>(response))
            }catch (e: HttpException){
                emit(Resource.Error<LoginResponse>(
                    message = e.localizedMessage?: "Something went wrong"
                ))
            }catch (e: IOException){
                emit(Resource.Error<LoginResponse>(
                    message = e.localizedMessage
                        ?: ("Could not reach server, " + "please check your internet")
                ))
            }catch (e: Exception){
                emit(Resource.Error<LoginResponse>(
                    message = e.localizedMessage?: "Something went wrong"
                ))
            }
        }

}