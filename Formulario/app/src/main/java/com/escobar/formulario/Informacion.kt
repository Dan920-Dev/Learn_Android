package com.escobar.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Informacion : AppCompatActivity() {

    // Data
    private var name = ""
    private var phone = 0
    private var email = ""

    // Views
    private lateinit var greetingTextView: TextView
    private lateinit var dataTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        bind()

        intent?.let { intent ->
            name = (intent.getStringExtra(MainActivity.KEY_NAME_USER)).toString()
            email = (intent.getStringExtra(MainActivity.KEY_EMAIL_USER)).toString()
            phone = intent.getIntExtra(MainActivity.KEY_PHONE_USER, 0)
        }

        onGreeting(name, email, phone)
    }

    private fun bind(){
        greetingTextView = findViewById(R.id.saludo)
        dataTextView = findViewById(R.id.data)
    }

    fun onGreeting(name: String, email: String, phone: Int) {
        greetingTextView.text = getString(R.string.saludo_text, name)
        dataTextView.text = getString(R.string.data_text_view, email, phone.toString())
    }
}