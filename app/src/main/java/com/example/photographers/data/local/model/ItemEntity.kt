package com.example.photographers.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class with format to save in database
 */

@Entity(tableName = "ItemEntity")
data class ItemEntity (
    @PrimaryKey val id: Int,
    var isFavorite: Boolean = false,
    val email: String,
    val firstName: String,
    val lastName: String,
    val isRemoved: Boolean,
    val description: String,
    val image: String?,
)

