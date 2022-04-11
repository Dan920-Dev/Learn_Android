package com.escobar.vaccinecovid

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var name = MutableLiveData("")
    var query = MutableLiveData("")

    fun getQuery(queryExt: String){
       query.value = queryExt
    }

    var queryy = query

    var typeVaccine = Transformations.map(queryy) { textQuery ->
        if (textQuery.isEmpty()){
            "SELECCIONE VACUNA"
        }else{
            "${textQuery}"
        }
    }
}