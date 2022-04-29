package com.escobar.dummydictionary

import android.app.Application
import com.escobar.dummydictionary.data.model.DummyDictionaryDatabase
import com.escobar.dummydictionary.repository.DictionaryRepository

class DummyDictionaryApplication : Application() {


    val dataBase by lazy {
        DummyDictionaryDatabase.getInstance(this)
    }

    fun getDictionaryRepository() = with(dataBase) {
        DictionaryRepository(wordDao(), synonymDao(), antonymDao())
    }
}