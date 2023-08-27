package com.example.photographers.domain.model

import com.google.gson.annotations.SerializedName

data class Item(
    val id: Int,
    val email: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("is_removed")val isRemoved: Boolean,
    val description: String,
    val image: String?,
)
