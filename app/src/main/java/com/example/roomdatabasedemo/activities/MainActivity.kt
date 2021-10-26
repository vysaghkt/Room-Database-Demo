package com.example.roomdatabasedemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemo.R
import com.example.roomdatabasedemo.adapter.UserAdapter
import com.example.roomdatabasedemo.database.User
import com.example.roomdatabasedemo.database.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var floatButton: FloatingActionButton
    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        floatButton = findViewById(R.id.float_btn)

        floatButton.setOnClickListener{
            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setRecyclerView()
    }

    private fun setRecyclerView(){
        viewModel.readAllData.observe(this, Observer {
            val userAdapter = UserAdapter(this,it)
            recyclerView.adapter = userAdapter

            userAdapter.setOnClickListener(object : UserAdapter.OnClickListener{
                override fun onClick(position: Int, user: User) {
                    val intent = Intent(this@MainActivity,UpdateActivity::class.java)
                    intent.putExtra(USER_DATA,user)
                    startActivity(intent)
                }
            })
        })
    }

    companion object{
        const val USER_DATA = "user_data"
    }
}