package com.example.photographers.data.repository

import com.example.photographers.data.local.ItemDatabase
import com.example.photographers.data.local.LocalDataSource
import com.example.photographers.data.remote.RemoteDataSource
import com.example.photographers.domain.model.Item
import com.example.photographers.domain.repository.RepositoryInterface

class Repository(): RepositoryInterface {

    override val localDataSource: LocalDataSource = LocalDataSource()
    override val remoteDataSource = RemoteDataSource()

    override suspend fun remoteFetchData() {
        remoteDataSource.fetchData() //call remote repo to get data from api
    }

    override fun localSaveFetchData(items: List<Item>, db: ItemDatabase?) {
        localDataSource.insertData(items, db) //call local repo to save data in db
        localDataSource.fetchData(db) //call local repo to get data from db
    }

}