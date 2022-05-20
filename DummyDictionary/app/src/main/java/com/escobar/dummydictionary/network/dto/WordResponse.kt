package com.escobar.dummydictionary.network.dto
import com.escobar.dummydictionary.data.model.Word
import com.google.gson.annotations.SerializedName


data class WordResponse (
  @SerializedName("count")
    val count: Int,
  @SerializedName("words")
    val words: List<Word>
        )