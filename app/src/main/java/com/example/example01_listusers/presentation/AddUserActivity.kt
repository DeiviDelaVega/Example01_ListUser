package com.example.example01_listusers.presentation

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
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


    fun validateStrings(): Boolean {
        val inputName = findViewById<EditText>(R.id.input_name)
        val inputLastName = findViewById<EditText>(R.id.input_lastName)
        var isValid = true

        when {
            inputName.text.isEmpty() || inputLastName.text.isEmpty() -> {
                inputName.error = "Vacio porfavor ingresa algo"
                inputLastName.error = "Vacio porfavor ingresa algo"
                isValid = false
            }

            inputName.text.length > 50 || inputLastName.text.length > 50 -> {
                inputName.error = "Es muy largo"
                inputLastName.error = "Es muy largo"
                isValid = false
            }

            inputName.text.length < 3 || inputLastName.text.length > 3 -> {
                inputName.error = "Es muy corto"
                inputLastName.error = "Es muy corto"
                isValid = false
            }
        }

        return isValid
    }

    fun validateNumber(): Boolean {
        val inputDni = findViewById<EditText>(R.id.input_dni)
        val inputPhone = findViewById<EditText>(R.id.input_phone)

        val inputDniText = inputDni.text
        val inputPhoneText = inputDni.text

        var isValid = true

        when {
            inputDniText.isEmpty() || inputPhoneText.isEmpty() -> {
                inputDni.error = "Vacio porfavor ingresa algo"
                inputPhone.error = "Vacio porfavor ingresa algo"
                isValid = false
            }

            inputDniText.length < 7 || inputPhoneText.length < 9 -> {
                inputDni.error = "Es muy corto, ponga el dni correctamente"
                inputPhone.error = "Es muy corto, ponga el numero de telefono correspondiente"
                isValid = false
            }

            inputDniText.length > 7 || inputPhoneText.length > 9 -> {
                inputDni.error = "Es muy largo, ponga el dni correctamente"
                inputPhone.error = "Es muy largo, ponga el numero de telefono correspondiente"
                isValid = false
            }
        }

        return isValid


    }

    fun validateEmail(): Boolean {

        val inputEmail = findViewById<EditText>(R.id.input_email)

        val inputEmailText = inputEmail.text.toString().trim()

        var isValid = true

        when {
            inputEmailText.isEmpty() -> {
                inputEmail.error = "Esta vacio el correo"
                isValid = false
            }

            !PatternsCompat.EMAIL_ADDRESS.matcher(inputEmailText).matches() -> {
                inputEmail.error = "Escribe un correo valido"
                isValid = false
            }

        }

        return isValid
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
            val isTextValid = validateStrings()
            val isNumberValid = validateNumber()
            val isEmailValid = validateEmail()

            if (!isTextValid || !isNumberValid|| !isEmailValid) {
                Toast.makeText(this, "Por favor corrige los campos vacíos", Toast.LENGTH_SHORT)
                    .show()
                Handler(Looper.getMainLooper()).postDelayed({
                    dialog.dismiss()
                }, 500)
            } else {
                Toast.makeText(this, "Player added", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        buttonCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }
}