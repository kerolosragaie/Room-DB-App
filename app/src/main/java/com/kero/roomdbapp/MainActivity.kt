package com.kero.roomdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.kero.roomdbapp.db.AppDatabase
import com.kero.roomdbapp.db.Users
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.activity_main.*

//list of users to get and show them
private val usersList = mutableListOf<Users>().apply {
    add(
        Users(
            name = "Kerollos Ragaie",
            email = "email@gmail.com",
            imageLink = "https://e1.pngegg.com/pngimages/212/696/png-clipart-anime-guys-blue-haired-male-anime-character.png"
        )
    )
    add(
        Users(
            name = "Mark",
            email = "email1@gmail.com",
            imageLink = "https://www.vhv.rs/dpng/d/111-1117621_boy-anime-characters-png-transparent-png.png"
        )
    )
    add(
        Users(
            name = "Tom",
            email = "email2@gmail.com",
            imageLink = "https://www.pikpng.com/pngl/m/380-3808709_bleach-anime-characters-png-clipart.png"
        )
    )
    add(
        Users(
            name = "Sara",
            email = "email3@gmail.com",
            imageLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReU1fQcqib0lX7FHwgMoIvOF8sakNRyAZrtA&usqp=CAU"
        )
    )
    add(
        Users(
            name = "Adham",
            email = "email4@gmail.com",
            imageLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQu_Ka-JNfmZQgxuTy03KoUSk95IhU4KAl-sg&usqp=CAU"
        )
    )
    add(
        Users(
            name = "Amir",
            email = "email5@gmail.com",
            imageLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqb_sAT_IWE-kVZaoidlRJQ_pJzUdMmxVnMg&usqp=CAU"
        )
    )
    add(
        Users(
            name = "Emy",
            email = "email6@gmail.com",
            imageLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6H_DY5cNkMRfOgT1PvJL-z91OfQi_9yCFwA&usqp=CAU"
        )
    )
    add(
        Users(
            name = "Lila",
            email = "email7@gmail.com",
            imageLink = "https://b1.pngbarn.com/png/431/502/taiga-brown-hair-female-anime-character-png-clip-art.png"
        )
    )
    add(
        Users(
            name = "Siri",
            email = "email6@gmail.com",
            imageLink = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaPPaV16uB9HV9GOl_ULjvp2aKiPdKgaPPLQ&usqp=CAU"
        )
    )
    add(Users(name = "Tomas", email = "email7@gmail.com"))
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appDb = Room.databaseBuilder(
            this@MainActivity,
            AppDatabase::class.java,
            "AppDatabase"
        ).allowMainThreadQueries().build()

        bt_show_db.setOnClickListener {
            val users: List<Users> = appDb.getUsersDao().getAllUsers()
            if (users.isEmpty()) {
                Toast.makeText(this, "No data available!", Toast.LENGTH_SHORT).show()
            } else {
                val fragmentManager = supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_frame, UsersFragment.newInstance(usersList))
                    .commitNow()
            }
        }

        bt_insert_db.setOnClickListener {
            appDb.getUsersDao().insertListOfUsers(usersList)
            Toast.makeText(this, "Data added successfully!", Toast.LENGTH_SHORT).show()
        }


    }
}