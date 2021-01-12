package com.csquare.codingtask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csquare.codingtask.model.LoginModel
import com.csquare.codingtask.repository.LoginRepository

class LoginViewModel : ViewModel() {


    var responseUserModel: MutableLiveData<LoginModel>? = null
    var loginModel = LoginModel("", "", "", "")


    /*To handle each error field */
    val errorMessageEmail = MutableLiveData<String>()
    val errorMessagePassword = MutableLiveData<String>()

    fun isLoginModelValid(): Boolean {
        errorMessageEmail.value = ""
        errorMessagePassword.value = ""

        if (loginModel.isEmailEmpty()) {
            errorMessageEmail.value = "Enter email id"
            return false
        }
        if (loginModel.isPasswordEmpty()) {
            errorMessagePassword.value = "Enter password"
            return false
        }
        if (!loginModel.isEmailValid()) {
            errorMessageEmail.value = "Incorrect email id"
            return false
        }
        return true
    }

    fun performLogin(): MutableLiveData<LoginModel>? {
        responseUserModel = LoginRepository.login(loginModel)
        return responseUserModel
    }
}
