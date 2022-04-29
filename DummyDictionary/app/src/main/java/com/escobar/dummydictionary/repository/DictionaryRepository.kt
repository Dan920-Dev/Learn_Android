package com.escobar.dummydictionary.repository
import androidx.lifecycle.MutableLiveData
import com.escobar.dummydictionary.data.dao.AntonymDao
import com.escobar.dummydictionary.data.dao.SynonymDao
import com.escobar.dummydictionary.data.model.Word
import com.escobar.dummydictionary.data.model.WordDao

class DictionaryRepository(
    private val wordDoa: WordDao,
    val synonymDao: SynonymDao,
    val antonymDao: AntonymDao
) {

    fun getAllWords() = wordDoa.getAllWords()

    suspend fun addWord(word: Word) {
        wordDoa.insertWord(word)
    }


}