package com.example.roomdatabasedemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemo.R
import com.example.roomdatabasedemo.database.User

class UserAdapter(private val context: Context,private val users: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val userId: TextView = view.findViewById(R.id.user_id)
        val userName: TextView = view.findViewById(R.id.user_name)
        val userAge: TextView = view.findViewById(R.id.user_age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.recycler_view_layout,
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]

        holder.userId.text = user.id.toString()
        holder.userName.text = user.name
        holder.userAge.text = user.age.toString()
    }

    override fun getItemCount(): Int {
        return users.size
    }
}