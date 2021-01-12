package com.csquare.codingtask.repository

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.csquare.codingtask.database.UserDao
import com.csquare.codingtask.database.UserEntity

class RoomDbRepository(private val userDao: UserDao) {

    val userList: LiveData<List<UserEntity>> = userDao.getUserList()

/*
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(userEntity: UserEntity) {
        userDao---------------------------------------------------------------------------------------------------------------------------------.insertUserData(userEntity)
    }
*/

}