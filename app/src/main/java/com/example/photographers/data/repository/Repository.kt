package com.example.photographers.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.photographers.data.local.LocalDataSource
import com.example.photographers.data.remote.ApiInterface
import com.example.photographers.data.remote.RemoteDataSource
import com.example.photographers.domain.model.Item
import com.example.photographers.domain.repository.RepositoryInterface

class Repository(
    override val remoteDataSource: RemoteDataSource,
    override val localDataSource: LocalDataSource,
    ): RepositoryInterface {

    private val apiInterface = ApiInterface.create()
    var items = MutableLiveData<List<Item>>()
    var itemsLocal = MutableLiveData<List<Item>>()

    override suspend fun fetchData() {
        val response = apiInterface.getData()

        if(response.isSuccessful) {
            items.postValue(response.body()!!.results)
            Log.d("apiResponse", "${response.body()!!.results}") //for dev
            //TODO insert in db
        }
        else {
            items.postValue(listOf())
            Log.d("apiResponseFail", "${response.errorBody()}") //for dev
        }
    }

    override suspend fun localFetchData() {
        localDataSource.fetchData() //call local repo to get data
        //itemsLocal.postValue(localDataSource.items.value)
    }

}