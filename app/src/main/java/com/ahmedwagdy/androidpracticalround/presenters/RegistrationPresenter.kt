package com.ahmedwagdy.androidpracticalround.presenters

import android.content.Context
import com.ahmedwagdy.androidpracticalround.contracts.RegistrationContract
import com.google.android.material.textfield.TextInputLayout

class RegistrationPresenter(view: RegistrationContract.View, context: Context): RegistrationContract.Presenter {
    private var view: RegistrationContract.View? = view
    private var context: Context? = context


    override fun validateEmail(textInputEmail: TextInputLayout): Boolean {
        val emailInput = textInputEmail.editText?.text.toString().trim()
        return when {
            emailInput.isEmpty() -> {
                textInputEmail.error = "Field can't be empty";
                false
            }
            else -> {
                textInputEmail.error = null;
                true
            }
        }
    }

    override fun validateUsername(textInputUsername: TextInputLayout): Boolean {
        val usernameInput  = textInputUsername.editText?.text.toString().trim()
        return when {
            usernameInput.isEmpty() -> {
                textInputUsername.error = "Field can't be empty";
                false
            }
            usernameInput.length > 15 -> {
                textInputUsername.error = "Username too long";
                false
            }
            else -> {
                textInputUsername.error = null
                true
            }
        }
    }

    override fun validatePassword(textInputPassword: TextInputLayout): Boolean {
        val passwordInput   = textInputPassword.editText?.text.toString().trim()
        return when {
            passwordInput.isEmpty() -> {
                textInputPassword.error = "Field can't be empty";
                false
            }
            else -> {
                textInputPassword.error = null;
                true
            }
        }
    }


}