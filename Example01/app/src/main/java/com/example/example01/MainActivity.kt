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

    // data
    private var emailUser : String = ""
    private var messageUser : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Validation State
        savedInstanceState?.let {
            emailUser = it.getString(EMAIL_USER," ")
            messageUser = it.getString(MESSAGE_USER, " ")
        }


        bind()
        validation()
    }

    // Link-up to views
    private fun bind() {
        email = findViewById(R.id.email_edit_text)
        message = findViewById(R.id.message_edit_text)
        send = findViewById(R.id.action_send)
    }

    private fun validation() {

        // Action
        send.setOnClickListener {

            // Validation
            if (emailUser.isEmpty() && messageUser.isNotEmpty()) {

                // Show ERROR
                val errorEmail = R.string.errorEmail
                email.hint = getString(errorEmail)

            }
            if (messageUser.isEmpty() && emailUser.isNotEmpty()) {

                // Show Error
                val errorMessage = R.string.errorMessage
                message.hint = getString(errorMessage)

            }

            if (emailUser.isEmpty() && messageUser.isEmpty()) {

                // ERROR, email and message is empty
                val errorEmail = R.string.errorEmail
                email.hint = getString(errorEmail)

                val errorMessage = R.string.errorMessage
                message.hint = getString(errorMessage)

            }

                // everything's fine!, open new activity
                var intent = Intent(this, MessageActivity::class.java)
                startActivity(intent)

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putString(EMAIL_USER, emailUser)
            putString(MESSAGE_USER, messageUser)
        }
    }

    companion object {
        const val EMAIL_USER = "EMAIL_USER"
        const val MESSAGE_USER = "MESSAGE_USER"
    }
}