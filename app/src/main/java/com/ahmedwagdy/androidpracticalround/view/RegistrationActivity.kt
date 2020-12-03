package com.ahmedwagdy.androidpracticalround.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmedwagdy.androidpracticalround.R
import com.ahmedwagdy.androidpracticalround.contracts.RegistrationContract
import com.ahmedwagdy.androidpracticalround.presenters.RegistrationPresenter

class RegistrationActivity : AppCompatActivity(),RegistrationContract.View {

    var presenter: RegistrationPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        title = "Registration"
        presenter = RegistrationPresenter(this, applicationContext)
    }

    override fun confirmInput() {

    }
}