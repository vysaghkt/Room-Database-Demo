package com.example.roomdatabasedemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasedemo.R
import com.example.roomdatabasedemo.database.User
import com.example.roomdatabasedemo.database.UserDatabase
import com.example.roomdatabasedemo.database.UserViewModel

class AddActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var addButton: Button

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        name = findViewById(R.id.name_et)
        age = findViewById(R.id.age_et)
        addButton = findViewById(R.id.add_btn)
        toolbar = findViewById(R.id.add_toolbar)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "ADD"
        }
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        addButton.setOnClickListener {
            if (name.text.toString().isEmpty() || age.text.toString().isEmpty()){
                Toast.makeText(this,"Enter All values",Toast.LENGTH_SHORT).show()
            }else{
                val user = User(
                    0,
                    name.text.toString(),
                    age.text.toString().toInt()
                )
                viewModel.addUser(user)
                Toast.makeText(this,"Successfully Details Entered",Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}