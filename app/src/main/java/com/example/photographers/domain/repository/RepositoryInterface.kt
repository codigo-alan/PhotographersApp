package com.example.photographers.domain.repository

import com.example.photographers.data.local.LocalDataSource
import com.example.photographers.data.remote.RemoteDataSource

interface RepositoryInterface {
    val remoteDataSource: RemoteDataSource
    val localDataSource: LocalDataSource
    suspend fun fetchData()
}