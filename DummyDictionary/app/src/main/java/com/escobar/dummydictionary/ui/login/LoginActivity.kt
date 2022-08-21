package com.escobar.dummydictionary.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.escobar.dummydictionary.DummyDictionaryApplication
import com.escobar.dummydictionary.MainActivity
import com.escobar.dummydictionary.R
import com.escobar.dummydictionary.databinding.ActivityLoginBinding
import com.escobar.dummydictionary.ui.WordViewModelFactory

class LoginActivity: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    val app by lazy {
        application as DummyDictionaryApplication
    }

    private val viewModelFactory by lazy {
        WordViewModelFactory(app.getLoginRepository())
    }

    private val viewModel: LoginViewModel by viewModels {
        viewModelFactory
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (app.isUserLogin()) {
            return starMainActivity()
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.status.observe(this) { status ->
            handleUIState(status)
        }
    }
    private fun handleUIState(status: LoginUiStatus) {
        when(status) {
            is LoginUiStatus.Error -> Log.d("Login List Status", "")
            LoginUiStatus.Loading -> Log.d("Login List Status", "Loading")
            LoginUiStatus.Resume -> Log.d("Login List Status", "Resume")
            is LoginUiStatus.Success -> {
                app.saveAuthToken(status.token)
                starMainActivity()
            }
        }
    }

    private fun starMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}