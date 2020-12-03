package com.ahmedwagdy.androidpracticalround.contracts

import com.google.android.material.textfield.TextInputLayout

interface RegistrationContract {
    interface View{
        fun register()
    }

    interface Presenter{
        fun getInputText(textInput:TextInputLayout):String
        fun validateUsername(textInputUsername: TextInputLayout):Boolean
        fun validateAge(textInputUserAge: TextInputLayout):Boolean
        fun validateEmail(textInputEmail: TextInputLayout):Boolean
        fun validatePassword(textInputPassword: TextInputLayout):Boolean

    }
}