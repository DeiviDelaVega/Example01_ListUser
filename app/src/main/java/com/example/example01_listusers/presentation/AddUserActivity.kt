package com.example.example01_listusers.presentation

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.example01_listusers.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AddUserActivity", "onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.add_user)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navigateToListUsers()
        addPlayer()
    }

    fun navigateToListUsers() {

        val button = findViewById<FloatingActionButton>(R.id.fab)
        button.setOnClickListener {
            val intent = Intent(this, ListUsersActivity::class.java)
            startActivity(intent)
        }
    }

    fun addPlayer() {
        val button = findViewById<MaterialButton>(R.id.button_add_player)
        button.setOnClickListener {
            dialogItem()
        }
    }

    private fun dialogItem() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.item_dialog)
        dialog.setCancelable(false)

        dialog.window?.setBackgroundDrawableResource(R.color.transparent)

        val buttonCheck = dialog.findViewById<ImageButton>(R.id.check_button)
        val buttonCancel = dialog.findViewById<ImageButton>(R.id.cancel_button)

        buttonCheck.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Player added", Toast.LENGTH_SHORT).show()
        }
        buttonCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }
}