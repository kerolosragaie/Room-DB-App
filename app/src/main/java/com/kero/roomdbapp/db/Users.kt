package com.kero.roomdbapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users_Table")
data class Users(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    val id:Int=0,

    @ColumnInfo(name="user_name")
    val name:String,

    @ColumnInfo(name="user_email")
    val email:String,

    @ColumnInfo(name="user_image_link")
    val imageLink:String?="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThRGcLNaorK4esT7jd4P_MfhhrzowqyTHRqA8Ku2vZW7KNrswJYoA0CcmhlTTPsWSQZ5I&usqp=CAU"
)


