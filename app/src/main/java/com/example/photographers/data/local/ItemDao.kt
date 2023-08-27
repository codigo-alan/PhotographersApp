package com.example.photographers.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.photographers.data.local.model.ItemEntity

@Dao
interface ItemDao {
    @Query("SELECT * FROM ItemEntity")
    fun getItems(): MutableList<ItemEntity>

    @Insert
    fun addItem(itemEntity: ItemEntity) //TODO add a list

    @Delete
    fun deleteItem(itemEntity: ItemEntity) //TODO delete a list

}