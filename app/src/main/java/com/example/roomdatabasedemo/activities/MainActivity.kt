package com.example.roomdatabasedemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemo.R
import com.example.roomdatabasedemo.adapter.UserAdapter
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
        viewModel.readAllData.observe(this, Observer {
            Log.i("Users :","$it")
            recyclerView.adapter = UserAdapter(this,it)
        })
    }

    override fun onResume() {
        super.onResume()

        viewModel.readAllData.observe(this, Observer {
            recyclerView.adapter = UserAdapter(this,it)
        })
    }
}