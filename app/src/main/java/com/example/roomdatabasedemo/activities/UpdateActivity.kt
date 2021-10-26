package com.example.roomdatabasedemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.roomdatabasedemo.R
import com.example.roomdatabasedemo.database.User

class UpdateActivity : AppCompatActivity() {

    private lateinit var updateToolbar: Toolbar
    private lateinit var updateName: EditText
    private lateinit var updateAge: EditText

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        updateToolbar = findViewById(R.id.update_toolbar)
        updateName = findViewById(R.id.update_name_et)
        updateAge = findViewById(R.id.update_age_et)

        if (intent.hasExtra(MainActivity.USER_DATA)){
            user = intent.getParcelableExtra(MainActivity.USER_DATA)
            Toast.makeText(this,"$user",Toast.LENGTH_SHORT).show()
        }

        setDataToField()
    }

    private fun setDataToField() {
        updateName.setText(user!!.name)
        updateAge.setText(user!!.age)
    }
}