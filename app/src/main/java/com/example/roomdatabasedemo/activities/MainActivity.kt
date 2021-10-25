package com.example.roomdatabasedemo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabasedemo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var floatButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatButton = findViewById(R.id.float_btn)

        floatButton.setOnClickListener{
            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }
    }
}