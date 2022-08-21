package com.escobar.dummydictionary.repository
import androidx.lifecycle.LiveData
import com.escobar.dummydictionary.data.model.DummyDictionaryDatabase
import com.escobar.dummydictionary.data.model.Word
import com.escobar.dummydictionary.network.ApiResponse
import com.escobar.dummydictionary.network.WordService
import okio.IOException
import retrofit2.HttpException

class DictionaryRepository(
    database: DummyDictionaryDatabase,
    private val api: WordService
) {
    private val wordDoa = database.wordDao()

    suspend fun getAllWords(): ApiResponse<LiveData<List<Word>>> {
        return try{
            val response = api.getAllWord()

            if (response.count > 0) {
               wordDoa.insertWord(response.words)
            }
            ApiResponse.Success(data = wordDoa.getAllWords())
        }catch (e: HttpException){
            ApiResponse.Error(exception = e)
        }catch (e: IOException){
            ApiResponse.Error(exception = e)
        }
    }
}