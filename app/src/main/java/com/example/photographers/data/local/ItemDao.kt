package com.example.photographers.data.local

import androidx.room.*
import com.example.photographers.data.local.model.ItemEntity

@Dao
interface ItemDao {
    @Query("SELECT * FROM ItemEntity")
    fun getItems(): MutableList<ItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(itemEntityList: List<ItemEntity>)

    @Delete
    fun deleteItem(itemEntity: ItemEntity) //TODO delete a list

}