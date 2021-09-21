package com.kero.roomdbapp.db

import androidx.room.*

@Dao
interface UsersDAO {
    //READ:
    @Query("Select * from Users_Table")
    fun getAllUsers():List<Users>

    @Query("Select * from Users_Table Where user_name = :name")
    fun getUsersByName(name:String):List<Users>

    //WRITE:
    //insert only one user of type UsersModel:
    @Insert
    fun insertUser(user:Users)

    /**
     * Insert a list in the database. If the item already exists, replace it.
     *
     * @param users the items to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertListOfUsers(users:MutableList<Users>)

    //DELETE:
    //delete using UsersModel
    @Delete
    fun deleteUser(user:Users)

    //delete using user id
    @Query("Delete From users_table Where user_id = :userId")
    fun deleteUserById(userId:String)
}