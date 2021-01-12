package com.csquare.codingtask.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csquare.codingtask.database.UserEntity
import com.csquare.codingtask.model.DataModel
import com.csquare.codingtask.model.UserListModel
import com.csquare.codingtask.repository.UserListRepository
import com.csquare.codingtask.repository.UserRepository

class UserListViewModel() : ViewModel() {


    var responseUserModel: MutableLiveData<UserListModel>? = null

    var userListModel = UserListModel(2, 2, 2, 2, null)


    fun getUserList(): MutableLiveData<UserListModel>? {
        responseUserModel = UserListRepository.userList(userListModel)

        return responseUserModel
    }
    


}

