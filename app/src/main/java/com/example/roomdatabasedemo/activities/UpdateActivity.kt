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
import com.example.roomdatabasedemo.database.UserViewModel
import java.lang.Exception

class UpdateActivity : AppCompatActivity() {

    private lateinit var updateToolbar: Toolbar
    private lateinit var updateName: EditText
    private lateinit var updateAge: EditText
    private lateinit var updateButton: Button
    private lateinit var deleteButton: Button

    private var user: User? = null
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        updateToolbar = findViewById(R.id.update_toolbar)
        updateName = findViewById(R.id.update_name_et)
        updateAge = findViewById(R.id.update_age)
        updateButton = findViewById(R.id.update_btn)
        deleteButton = findViewById(R.id.delete_btn)

        if (intent.hasExtra(MainActivity.USER_DATA)){
            user = intent.getParcelableExtra(MainActivity.USER_DATA)
            Toast.makeText(this,"$user",Toast.LENGTH_SHORT).show()
        }

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        try {
            updateName.setText(user!!.name)
        }catch (e: Exception){
            Log.e("Error :", "$e")
        }

        updateButton.setOnClickListener {
            if (updateName.text.toString().isEmpty() || updateAge.text.toString().isEmpty()){
                Toast.makeText(this,"Enter All values",Toast.LENGTH_SHORT).show()
            }else{
                val updatedUser = User(
                    user!!.id,
                    updateName.text.toString(),
                    updateAge.text.toString().toInt()
                )
                viewModel.updateUser(updatedUser)
                Toast.makeText(this,"Successfully Details Updated",Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        deleteButton.setOnClickListener {
            val deleteUser = User(
                user!!.id,
                updateName.text.toString(),
                updateAge.text.toString().toInt()
            )
            viewModel.deleteUser(deleteUser)
            Toast.makeText(this,"Successfully Details Deleted",Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}