package com.csquare.codingtask.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

open class BaseActivity : AppCompatActivity() {



   private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressDialog = ProgressDialog(this)
        progressDialog!!.setMessage("Please wait...")
    }

    protected fun showProgress() {
        progressDialog?.show()
    }

    protected fun hideHideProgress() {
        progressDialog?.hide()
    }

}
