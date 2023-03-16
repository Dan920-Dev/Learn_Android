package com.example.example01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    // Variables a usar
    private lateinit var email : EditText
    private lateinit var message : EditText
    private lateinit  var send : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        // Action
        send.setOnClickListener { _ ->
            val emailUser  = email.text
            val messageUser = message.text
        }

    }


    fun bind(){
        email = findViewById(R.id.email_edit_text)
        message = findViewById(R.id.message_edit_text)
        send = findViewById(R.id.action_send)
    }

}