package com.ahmedwagdy.androidpracticalround.presenters

import android.content.Context
import com.ahmedwagdy.androidpracticalround.contracts.MainContract
import com.ahmedwagdy.androidpracticalround.contracts.RegistrationContract

class RegistrationPresenter(view: RegistrationContract.View, context: Context): RegistrationContract.Presenter {
    private var view: RegistrationContract.View? = view
    private var context: Context? = context
}