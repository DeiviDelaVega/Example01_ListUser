package com.example.example01_listusers.presentation

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
    }

    fun listItemRecycler() {

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val userAdapter = UserAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        userAdapter.users = User.data

        recyclerView.setHasFixedSize(true)
    }
}