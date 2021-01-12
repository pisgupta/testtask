package com.csquare.codingtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(UserEntity::class), version = 1, exportSchema = false)
abstract class CsquareDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CsquareDataBase? = null

        fun getDatabase(context: Context): CsquareDataBase {
            // if the INSTANCE is not null, then re-turn it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CsquareDataBase::class.java,
                    "CsquareDB"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
