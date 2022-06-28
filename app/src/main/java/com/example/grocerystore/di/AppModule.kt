package com.example.grocerystore.di

import com.example.grocerystore.data.remote.Api
import com.example.grocerystore.data.repositories.UserRepositoryImpl
import com.example.grocerystore.domain.repositories.UserRepository
import com.example.grocerystore.domain.useCases.auth.AuthenticationUsecases
import com.example.grocerystore.domain.useCases.auth.Login
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    val baseUrl = "https://gorceriesonline.herokuapp.com/"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideGroceriesApi(client: OkHttpClient): Api{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: Api): UserRepository{
        return UserRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideAuthenticationUsecases(userRepository: UserRepository): AuthenticationUsecases{
        return AuthenticationUsecases(
            login = Login(userRepository= userRepository)
        )
    }
}