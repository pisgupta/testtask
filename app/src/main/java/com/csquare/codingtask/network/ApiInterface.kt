package com.example.mvvmkotlinexample.retrofit

import com.csquare.codingtask.model.LoginModel
import com.csquare.codingtask.model.UserListModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("login")
    fun login(@Body request: LoginModel): Call<LoginModel>

    @Headers("Content-Type: application/json")
    @GET("users")
    fun getUserList(@Query("page") page: Int): Call<UserListModel>


}