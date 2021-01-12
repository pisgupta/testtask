package com.csquare.codingtask.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
public interface UserDao{

    @Query("SELECT * FROM table_user")
    fun getUserList(): LiveData<List<UserEntity>>

    @Insert()
    fun insertUserData(userEntity: UserEntity)



}