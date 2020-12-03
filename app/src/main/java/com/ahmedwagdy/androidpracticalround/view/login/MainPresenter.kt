package com.ahmedwagdy.androidpracticalround.presenters

import android.content.Context
import com.ahmedwagdy.androidpracticalround.contracts.MainContract

class MainPresenter(view:MainContract.View, context: Context) : MainContract.Presenter {

    private var view: MainContract.View? = view
    private var context: Context? = context

}