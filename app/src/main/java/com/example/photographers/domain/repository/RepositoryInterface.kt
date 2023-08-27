package com.example.photographers.domain.repository

import com.example.photographers.data.local.ItemDatabase
import com.example.photographers.data.local.LocalDataSource
import com.example.photographers.data.remote.RemoteDataSource
import com.example.photographers.domain.model.Item

interface RepositoryInterface {
    val remoteDataSource: RemoteDataSource
    val localDataSource: LocalDataSource
    suspend fun remoteFetchData() //To get data from api
    fun localSaveFetchData(items: List<Item>, db: ItemDatabase?) //To insert and get data from local db
}