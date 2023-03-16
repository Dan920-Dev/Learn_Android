package com.example.example01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    // Variables a usar
    private lateinit var email: EditText
    private lateinit var message: EditText
    private lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        validation()

    }

    // Link-up to views
    fun bind() {
        email = findViewById(R.id.email_edit_text)
        message = findViewById(R.id.message_edit_text)
        send = findViewById(R.id.action_send)
    }

    fun validation() {

        // Action
        send.setOnClickListener { _ ->

            val emailUser = email.text
            val messageUser = message.text


            // Validation
            if (emailUser.isEmpty() && messageUser.isNotEmpty()) {

                // Show ERROR
                val errorEmail = R.string.errorEmail
                email.hint = getString(errorEmail)

            } else if (messageUser.isEmpty() && emailUser.isNotEmpty()) {

                // Show Error
                val errorMessage = R.string.errorMessage
                message.hint = getString(errorMessage)

            } else if (emailUser.isEmpty() && messageUser.isEmpty()) {

                // ERROR, email and message is empty
                val errorEmail = R.string.errorEmail
                email.hint = getString(errorEmail)

                val errorMessage = R.string.errorMessage
                message.hint = getString(errorMessage)

            } else {

                // everything's fine!, open new activity
                var intent = Intent(this, MessageActivity::class.java)
                startActivity(intent)
            }
        }
    }


}