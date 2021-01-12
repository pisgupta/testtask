package com.csquare.codingtask.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.csquare.codingtask.database.CsquareDataBase
import com.csquare.codingtask.database.UserDao
import com.csquare.codingtask.database.UserEntity

class UserRepository internal constructor(private val userDao: UserDao) {

    fun insert(userEntity: UserEntity) {
        insertAsyncTask(userDao).execute(userEntity)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: UserDao) :
        AsyncTask<UserEntity, Void, Void>() {

        override fun doInBackground(vararg params: UserEntity): Void? {
            mAsyncTaskDao.insertUserData(params[0])
            return null
        }
    }

    val userList: LiveData<List<UserEntity>> = userDao.getUserList()
}

