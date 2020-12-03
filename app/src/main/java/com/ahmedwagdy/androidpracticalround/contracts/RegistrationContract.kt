package com.ahmedwagdy.androidpracticalround.contracts

import com.google.android.material.textfield.TextInputLayout

interface RegistrationContract {
    interface View{
        fun confirmInput()
    }

    interface Presenter{
        fun validateEmail(textInputEmail: TextInputLayout):Boolean
        fun validateUsername(textInputUsername: TextInputLayout):Boolean
        fun validatePassword(textInputPassword: TextInputLayout):Boolean

    }
}