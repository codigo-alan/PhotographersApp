package com.example.photographers.data.repository

import com.example.photographers.data.local.LocalDataSource
import com.example.photographers.data.remote.RemoteDataSource
import com.example.photographers.domain.repository.RepositoryInterface

class Repository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource): RepositoryInterface {
}