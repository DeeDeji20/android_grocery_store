package com.example.grocerystore.general.util

import android.text.TextUtils

object Util {
    fun validateInput(inputValue: String, inputType: InputType): Pair<Boolean, String>{
        when(inputType){
            InputType.EMAIL -> {
                val emailValid =
                    !TextUtils.isEmpty(inputValue)
                            && android.util.Patterns.EMAIL_ADDRESS.matcher(inputValue).matches()
                return if (emailValid){
                    Pair(emailValid,"")
                }else{
                    Pair(emailValid, "Invalid Email Provided")
                }
            }

            InputType.PASSWORD -> {
                val passwordValid =
                    !TextUtils.isEmpty(inputValue)
                            && inputValue.length > 5
                return if (passwordValid){
                    Pair(passwordValid,"")
                }else{
                    Pair(passwordValid, "Password can't be less than 5 characters")
                }
            }

            InputType.TEXT -> {
                val textValid =
                    !TextUtils.isEmpty(inputValue)

                return if (textValid){
                    Pair(textValid,"")
                }else{
                    Pair(textValid, "Text cannot be empty")
                }
            }
        }

    }
}