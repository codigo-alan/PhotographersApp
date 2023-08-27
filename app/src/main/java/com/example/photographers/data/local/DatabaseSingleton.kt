package com.example.photographers.data.local


object DatabaseSingleton {
    val database: ItemDatabase
        get() = ItemApplication.database
}