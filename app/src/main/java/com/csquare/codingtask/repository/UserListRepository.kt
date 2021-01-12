package com.csquare.codingtask.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.csquare.codingtask.model.LoginModel
import com.csquare.codingtask.model.UserListModel
import com.example.mvvmkotlinexample.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

object UserListRepository{

    val responseUserListModel = MutableLiveData<UserListModel>()

    fun userList(userListModel: UserListModel): MutableLiveData<UserListModel> {

        val call = RetrofitClient.apiInterface.getUserList(userListModel!!.page)

        call.enqueue(object : Callback<UserListModel>{
            override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                Log.d("","")
            }

            override fun onResponse(call: Call<UserListModel>, response: Response<UserListModel>) {
              responseUserListModel.value = response.body()
            }
        })

        return responseUserListModel
    }


}