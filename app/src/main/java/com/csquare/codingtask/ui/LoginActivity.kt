package com.csquare.codingtask.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.csquare.codingtask.R
import com.csquare.codingtask.viewmodel.LoginViewModel
import com.example.testproject.util.showResponseMessage

class LoginActivity : BaseActivity() {

    lateinit var loginBinding: com.csquare.codingtask.databinding.ActivityMainBinding
    lateinit var loginViewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }

    fun initBinding() {
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loginViewModel = ViewModelProvider(LoginActivity@ this).get(LoginViewModel::class.java)

        //Binding view model to UI
        loginBinding.viewModel = loginViewModel
        loginBinding.lifecycleOwner = this
    }

    /*To handle login button click from login activity*/
    fun performLogin(view: View) {
        if (loginViewModel.isLoginModelValid()) {
            showProgress()

            var userModel = loginViewModel.performLogin()

            userModel?.observe(this, Observer {
                hideHideProgress()

                if (it.error == null) {
                   var intent = Intent(this,UserLisActivity::class.java)
                    startActivity(intent)
                } else {
                    this.showResponseMessage(it.error)
                }
            })
        }
    }

}


