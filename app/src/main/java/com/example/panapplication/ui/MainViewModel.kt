package com.example.panapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val successResponse:MutableLiveData<String>by lazy {
        MutableLiveData<String>()
    }
    fun saveData( pan:String , dob: String): LiveData<String> {
        GlobalScope.launch (Dispatchers.Main){
            delay(1000)
            successResponse.value= "Success"
        }

        return  successResponse
    }
    fun getResponse(): LiveData<String> {
        return successResponse
    }
}