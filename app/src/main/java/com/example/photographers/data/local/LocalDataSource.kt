package com.example.photographers.data.local

import androidx.lifecycle.MutableLiveData
import com.example.photographers.data.local.model.ItemEntity
import com.example.photographers.domain.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LocalDataSource {

    val items = MutableLiveData<List<Item>>().apply { listOf<Item>() }

    fun fetchData() {

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val itemsTemporal = ItemApplication.database.itemDao().getItems().map(::entityToItem)
                withContext(Dispatchers.Main) {
                    items.postValue(itemsTemporal)
                }
            } catch (e: Exception) {
                items.postValue(listOf())
            }
        }

    }

    private fun entityToItem(itemEntity: ItemEntity): Item {
        return Item(
            itemEntity.id,
            itemEntity.email,
            itemEntity.firstName,
            itemEntity.lastName,
            itemEntity.isRemoved,
            itemEntity.description,
            itemEntity.image)

    }

}