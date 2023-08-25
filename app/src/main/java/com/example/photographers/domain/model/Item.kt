package com.example.photographers.domain.model

import com.google.gson.annotations.SerializedName

data class Item(
    val id: Int,
    //val guid: String,
    val email: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("is_removed")val isRemoved: Boolean,
    val description: String,
    //val avatar: String?,
    val image: String?,
    /*val facebook: String?,
    val instagram: String?,
    val webpage: String?*/
)
