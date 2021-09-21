package com.kero.roomdbapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kero.roomdbapp.db.Users
import kotlinx.android.synthetic.main.rv_item.view.*

class UsersAdapter(private val usersList:List<Users>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rv_item,parent,false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentUser = usersList[position]
        holder.itemView.tv_username.text = currentUser.name
        holder.itemView.tv_email.text = currentUser.email
        Glide.with(holder.itemView.image_view).load(currentUser.imageLink)
            .placeholder(R.drawable.account_circle).into(holder.itemView.image_view)

    }

    override fun getItemCount(): Int {
        return usersList.size
    }

}
class UsersViewHolder(view: View):RecyclerView.ViewHolder(view){}
