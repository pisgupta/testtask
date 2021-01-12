package com.csquare.codingtask.repository

import androidx.lifecycle.MutableLiveData
import com.csquare.codingtask.model.LoginModel
import com.example.mvvmkotlinexample.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoginRepository{

    val responseLoginModel = MutableLiveData<LoginModel>()

    fun login(userModel: LoginModel): MutableLiveData<LoginModel> {

        val call = RetrofitClient.apiInterface.login(userModel)

        call.enqueue(object: Callback<LoginModel> {
            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                responseLoginModel.value?.error = t.message!!
            }

            override fun onResponse(
                call: Call<LoginModel>,
                response: Response<LoginModel>
            ) {
                responseLoginModel.value = response.body()
            }
        })

        return responseLoginModel
    }
}