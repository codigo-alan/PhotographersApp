package com.example.photographers.data.local

import android.app.Application
import androidx.room.Room

class ItemApplication: Application() {
    companion object {
        lateinit var database: ItemDatabase
        var isOnCreateExecuted = false
    }
    override fun onCreate() {
        super.onCreate()
        isOnCreateExecuted = true
        database = Room.databaseBuilder(this,
            ItemDatabase::class.java,
            "ItemDatabase").build()
    }

}
