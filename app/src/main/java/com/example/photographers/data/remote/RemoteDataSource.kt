package com.example.photographers.data.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.photographers.domain.model.Item

class RemoteDataSource() {

    private val apiInterface = ApiInterface.create()
    var itemsRemote = MutableLiveData<List<Item>>()
    suspend fun fetchData() {
        val response = apiInterface.getData()

        if(response.isSuccessful) {
            itemsRemote.postValue(response.body()!!.results)
            Log.d("apiResponse", "${response.body()!!.results}") //for dev
        }
        else {
            itemsRemote.postValue(listOf())
            Log.d("apiResponseFail", "${response.errorBody()}") //for dev
        }
    }
}