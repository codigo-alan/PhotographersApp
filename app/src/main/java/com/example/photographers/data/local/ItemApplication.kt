package com.example.photographers.data.local

import android.app.Application
import androidx.room.Room

class ItemApplication: Application() {
    companion object {
        lateinit var database: ItemDatabase
    }
    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this,
            ItemDatabase::class.java,
            "ItemDatabase").build()
    }

}
