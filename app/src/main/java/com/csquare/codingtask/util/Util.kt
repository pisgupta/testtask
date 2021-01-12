package com.example.testproject.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("setErrorMessage")
fun TextInputLayout.showError(errorMessage:String?){
    this.error=errorMessage
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showResponseMessage(message:String) {
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}