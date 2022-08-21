package com.escobar.dummydictionary

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.escobar.dummydictionary.data.model.DummyDictionaryDatabase
import com.escobar.dummydictionary.network.RetrofitInstance
import com.escobar.dummydictionary.repository.DictionaryRepository
import com.escobar.dummydictionary.repository.LoginRepository

class DummyDictionaryApplication : Application() {

    private val prefs: SharedPreferences by lazy {
        getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
    }

    private val dataBase by lazy {
        DummyDictionaryDatabase.getInstance(this)
    }

    private fun getApiService() = with(RetrofitInstance) {
        setToken(getToken())
        getWordServices()
    }

    fun getDictionaryRepository() =
        DictionaryRepository(dataBase, getApiService())

    fun getLoginRepository() =
        LoginRepository(getApiService())

    private  fun getToken() : String = prefs.getString(USER_TOKEN, "")!!

    fun isUserLogin() = getToken() !=""

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }

}