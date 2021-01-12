package com.csquare.codingtask

import android.app.Application
import com.csquare.codingtask.database.CsquareDataBase
import com.csquare.codingtask.repository.RoomDbRepository
import com.csquare.codingtask.repository.UserRepository

class AppApplication : Application() {

    val database by lazy { CsquareDataBase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}