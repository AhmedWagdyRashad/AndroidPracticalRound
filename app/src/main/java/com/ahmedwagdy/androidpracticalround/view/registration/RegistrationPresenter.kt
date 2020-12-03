package com.ahmedwagdy.androidpracticalround.presenters

import android.content.Context
import android.util.Patterns
import com.ahmedwagdy.androidpracticalround.contracts.RegistrationContract
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class RegistrationPresenter(view: RegistrationContract.View, context: Context): RegistrationContract.Presenter {
    private var view: RegistrationContract.View? = view
    private var context: Context? = context

    private val PASSWORD_PATTERN: Pattern? =
        Pattern.compile(("^"+  "(?=.*[0-9])" +         //at least 1 digit
    "(?=.*[a-z])" +         //at least 1 lower case letter
    "(?=.*[A-Z])" +         //at least 1 upper case letter
    //"(?=.*[a-zA-Z])" +  //any letter
    "(?=.*[@#$%^&+=])" +  //at least 1 special character
    "(?=\\S+$)" +  //no white spaces
    ".{8,}" +  //at least 8 characters
    "$"))


    override fun getInputText(textInput: TextInputLayout): String
            = textInput.editText?.text.toString().trim()

    override fun validateUsername(textInputUsername: TextInputLayout): Boolean {
        val usernameInput  = getInputText(textInputUsername)
        return when {
            usernameInput.isEmpty() -> {
                textInputUsername.error = "Field can't be empty";
                false
            }
            usernameInput.length > 10 -> {
                textInputUsername.error = "Username too long";
                false
            }
            else -> {
                textInputUsername.error = null
                true
            }
        }
    }

    override fun validateAge(textInputUserAge: TextInputLayout): Boolean {
        val userAgeInput  = getInputText(textInputUserAge)
        return when {
            userAgeInput.isEmpty() -> {
                textInputUserAge.error = "Field can't be empty";
                false
            }
            userAgeInput.toInt() < 18 -> {
                textInputUserAge.error = "Age must be over 18 years old";
                false
            }
            else -> {
                textInputUserAge.error = null
                true
            }
        }
    }

    override fun validateEmail(textInputEmail: TextInputLayout): Boolean {
        val emailInput = getInputText(textInputEmail)
        return when {
            emailInput.isEmpty() -> {
                textInputEmail.error = "Field can't be empty"
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches() ->{
                textInputEmail.error = "Please enter a valid email address"
                false
            }
            else -> {
                textInputEmail.error = null
                true
            }
        }
    }

    override fun validatePassword(textInputPassword: TextInputLayout): Boolean {
        val passwordInput   = getInputText(textInputPassword)
        return when {
            passwordInput.isEmpty() -> {
                textInputPassword.error = "Field can't be empty"
                false
            }
            !PASSWORD_PATTERN?.matcher(passwordInput)?.matches()!! -> {
                textInputPassword.error = "Password should contain at least 8 characters, " +
                        "1 digit, 1 lower case letter, 1 upper case letter, " +
                        "1 special character, and no white spaces"
                false
            }
            else -> {
                textInputPassword.error = null
                true
            }
        }
    }


}