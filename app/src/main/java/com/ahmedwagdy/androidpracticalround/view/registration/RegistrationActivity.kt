package com.ahmedwagdy.androidpracticalround.view.registration

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ahmedwagdy.androidpracticalround.R
import com.ahmedwagdy.androidpracticalround.contracts.RegistrationContract
import com.ahmedwagdy.androidpracticalround.presenters.RegistrationPresenter
import kotlinx.android.synthetic.main.activity_registration.*


class RegistrationActivity : AppCompatActivity(),RegistrationContract.View {

    var presenter: RegistrationPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        title = "Registration"
        presenter = RegistrationPresenter(this, applicationContext)
        btn_register.setOnClickListener {
            register()
        }
    }


    override fun register() {


        val isValidFirstName = presenter?.validateUsername(text_input_first_name)
        val isValidLastName = presenter?.validateUsername(text_input_last_name)
        val isValidAge = presenter?.validateAge(text_input_age)
        val isValidEmail = presenter?.validateEmail(text_input_email)
        val isValidPassword = presenter?.validatePassword(text_input_password)

        if (isValidFirstName==false || isValidLastName==false || isValidAge==false
            ||isValidEmail==false || isValidPassword==false){
                return
        }else{
            var input = "FirstName: " + text_input_first_name.editText?.text.toString()
            input += "\n"
            input += "LastName: " + text_input_last_name.editText?.text.toString()
            input += "\n"
            input += "Age: " + text_input_age.editText?.text.toString()
            input += "\n"
            input += "Email: " + text_input_email.editText?.text.toString()
            input += "\n"
            input += "Password: " + text_input_password.editText?.text.toString()
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }
}