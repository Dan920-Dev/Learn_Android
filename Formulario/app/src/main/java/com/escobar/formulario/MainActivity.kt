package com.escobar.formulario

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    // Data
    private var name = ""
    private var phone = 0
    private var email = ""

    // Views
    private lateinit var sendButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListeners()
    }


    private fun addListeners(){
        sendButton.setOnClickListener{
            onSend()
        }
    }


    private fun onSend(){
        // Data
        name = nameEditText.text.toString()
        email = emailEditText.text.toString()
        phone = (phoneEditText.text.toString()).toInt()

        // Intent
        val intent = Intent(this, Informacion::class.java)
        intent.putExtra(KEY_NAME_USER, name)
        intent.putExtra(KEY_EMAIL_USER, email)
        intent.putExtra(KEY_PHONE_USER, phone)
        startActivity(intent)
    }

    private fun bind(){
        nameEditText = findViewById(R.id.editTextTextPersonName2)
        phoneEditText = findViewById(R.id.editTextPhone3)
        emailEditText = findViewById(R.id.editTextTextEmailAddress)
        sendButton = findViewById(R.id.button)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    companion object{
        private val TAG = MainActivity::class.simpleName
        const val KEY_NAME_USER = "Nombre"
        const val KEY_PHONE_USER = "phone"
        const val KEY_EMAIL_USER = "Email"
    }
}