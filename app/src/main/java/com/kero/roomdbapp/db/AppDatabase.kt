package com.kero.roomdbapp.db

import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * Now we are creating database
 * Note: database which contains tables we created
 * */
@Database(
    entities = [Users::class],
    version = 1,
)
abstract class AppDatabase:RoomDatabase(){
    abstract fun getUsersDao():UsersDAO
}
