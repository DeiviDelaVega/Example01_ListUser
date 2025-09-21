package com.example.example01_listusers.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example01_listusers.R
import androidx.recyclerview.widget.RecyclerView
import com.example.example01_listusers.data.User
import com.example.example01_listusers.adapter.UserAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListUsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_users)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listItemRecycler()
        backButtonAddUser()
    }

    fun listItemRecycler() {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val userAdapter = UserAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        userAdapter.users = User.data

        recyclerView.setHasFixedSize(true)
    }

    fun backButtonAddUser() {
        val button = findViewById<MaterialButton>(R.id.button_back)
        button.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }
    }
}