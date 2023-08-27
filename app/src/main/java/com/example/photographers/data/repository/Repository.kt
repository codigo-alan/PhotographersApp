package com.example.photographers.data.repository

import com.example.photographers.data.local.ItemDatabase
import com.example.photographers.data.local.LocalDataSource
import com.example.photographers.data.remote.RemoteDataSource
import com.example.photographers.domain.model.Item
import com.example.photographers.domain.repository.RepositoryInterface

class Repository(): RepositoryInterface {

    override val localDataSource: LocalDataSource = LocalDataSource()
    override val remoteDataSource = RemoteDataSource()

    /*private val _dataFlow: MutableStateFlow<List<Item>> = MutableStateFlow(listOf())
    val dataFlow: Flow<List<Item>> get() = _dataFlow*/

    override suspend fun remoteFetchData() {
        remoteDataSource.fetchData() //call remote repo to get data
    }

    override suspend fun localFetchData(db: ItemDatabase?) {
        localDataSource.fetchData(db) //call local repo to get data
    }

    fun saveLocalData(items: List<Item>, db: ItemDatabase?) {
        localDataSource.insertItemsList(items,db)
    }

}