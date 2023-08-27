package com.example.photographers.domain.repository

import com.example.photographers.data.local.ItemDatabase
import com.example.photographers.data.local.LocalDataSource
import com.example.photographers.data.remote.RemoteDataSource

interface RepositoryInterface {
    val remoteDataSource: RemoteDataSource
    val localDataSource: LocalDataSource
    suspend fun remoteFetchData() //To get data from api
    suspend fun localFetchData(db: ItemDatabase?) //To get data from local db TODO provisory the param
}