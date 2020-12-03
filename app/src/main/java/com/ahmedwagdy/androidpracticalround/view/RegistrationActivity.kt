package com.ahmedwagdy.androidpracticalround.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ahmedwagdy.androidpracticalround.R
import com.ahmedwagdy.androidpracticalround.contracts.RegistrationContract
import com.ahmedwagdy.androidpracticalround.presenters.RegistrationPresenter
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_registration.*


class RegistrationActivity : AppCompatActivity(),RegistrationContract.View {

    var presenter: RegistrationPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        title = "Registration"
        presenter = RegistrationPresenter(this, applicationContext)
    }

    override fun confirmInput() {
        val isValidEmail = presenter?.validateEmail(text_input_email)
        val isValidUserName = presenter?.validateUsername(text_input_username)
        val isValidPassword = presenter?.validatePassword(text_input_password)
        if (!isValidEmail!! ||!isValidUserName!! ||isValidPassword!!){
                return
        }

        var input = "Email: " + text_input_email.editText?.text.toString()
        input += "\n"
        input += "Username: " + text_input_username.editText?.text.toString()
        input += "\n"
        input += "Password: " + text_input_password.editText?.text.toString()
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }
}