package com.example.photographers.domain.model

data class Data(
    val count: Int,
    //val next: String?, //TODO may be Ignore just deleting it
    //val previous: String?,
    val results: List<Item>,
    //val timestamp: String
)
