package com.escobar.dummydictionary.ui.word

import androidx.lifecycle.LiveData
import com.escobar.dummydictionary.data.model.Word

sealed class  WordUiState() {
    object Loading : WordUiState()
    class Error(val exception: Exception) : WordUiState()

    data class Success(val word: LiveData<List<Word>>) : WordUiState()
}