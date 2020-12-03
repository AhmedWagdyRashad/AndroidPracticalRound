package com.ahmedwagdy.androidpracticalround.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmedwagdy.androidpracticalround.R
import com.ahmedwagdy.androidpracticalround.contracts.MainContract
import com.ahmedwagdy.androidpracticalround.presenters.MainPresenter
import com.ahmedwagdy.androidpracticalround.view.RegistrationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MainContract.View {

    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Login"
        presenter = MainPresenter(this, applicationContext)

        create_account_txt.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }
}