package com.escobar.dummydictionary.data.model

import androidx.lifecycle.LiveData
import androidx.room.*



    @Dao
    interface WordDao {

        @Query("SELECT * FROM  word_table")
        fun getAllWords(): LiveData<List<Word>>

        @Insert
        suspend fun insertWord(word: Word)

        @Update
        suspend fun updateWord(word: Word)

        @Delete
        suspend fun deleteWord(word: Word)
    }









