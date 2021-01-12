package com.csquare.codingtask.model

data class LoginModel(var email: String, var password: String, var token:String, var error:String) {

    /*To validate model i have created separated method for each properties so that we can test is independently*/

    fun isEmailEmpty(): Boolean {
        return email.isNullOrEmpty()
    }

    fun isPasswordEmpty(): Boolean {
        return password.isNullOrEmpty()
    }

    /*To validated emil id*/

    fun isEmailValid(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}