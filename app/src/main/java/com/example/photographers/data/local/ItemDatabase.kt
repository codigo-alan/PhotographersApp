package com.example.photographers.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photographers.data.local.model.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

}
