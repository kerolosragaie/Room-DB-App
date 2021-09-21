package com.kero.roomdbapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kero.roomdbapp.db.Users
import kotlinx.android.synthetic.main.activity_fragment.*
import java.io.Serializable

class UsersFragment:Fragment(){

    private var usersList:List<Users>?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        usersList = arguments?.getSerializable("usersList") as List<Users>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = usersList?.let { UsersAdapter(it) }
    }

    companion object{
        fun newInstance(usersList:List<Users>):UsersFragment{
            val usersFragment = UsersFragment()
            val bundle = Bundle()
            usersList?.let {
                bundle.putSerializable("usersList",usersList as Serializable)
            }
            usersFragment.arguments = bundle
            return usersFragment
        }
    }


}