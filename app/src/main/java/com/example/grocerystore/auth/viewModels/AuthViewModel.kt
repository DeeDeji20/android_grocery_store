package com.example.grocerystore.auth.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocerystore.auth.events.AuthEvent
import com.example.grocerystore.auth.state.AuthState
import com.example.grocerystore.data.remote.request.LoginRequest
import com.example.grocerystore.domain.useCases.auth.AuthenticationUsecases
import com.example.grocerystore.general.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authenticationUsecases: AuthenticationUsecases
): ViewModel() {

    private val _eventFlow = MutableSharedFlow<AuthEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    private val _state = mutableStateOf(
        AuthState(
            isAuthenticated = false
        )
    )
    val state: State<AuthState> = _state

    fun createEvent(event: AuthEvent){
        onEvent(event)
    }

    private fun onEvent(event: AuthEvent) {
        when(event){
            is AuthEvent.Login ->{
                val request = LoginRequest(
                    email = event.email,
                    password = event.password
                )
                login(request= request)
            }
            else->{}
        }
    }

    private fun login(request: LoginRequest){
        authenticationUsecases.login(request = request)
            .onEach{
                when(it){
                    is Resource.Loading ->{
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Success ->{
                        _state.value = state.value.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(
                            AuthEvent.LoginSuccess
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }

}