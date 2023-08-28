package com.example.photographers.data.local

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.photographers.data.local.model.ItemEntity
import com.example.photographers.domain.model.Item
import kotlinx.coroutines.*

class LocalDataSource() {

    var itemsLocal = MutableLiveData<List<Item>>().apply { listOf<Item>() }

    fun fetchData(db: ItemDatabase?) {

        CoroutineScope(Dispatchers.IO).launch {

            try {
                val itemsTemp = db!!.itemDao().getItems().map(::entityToItem)
                withContext(Dispatchers.Main) {
                    itemsLocal.postValue(itemsTemp)
                    Log.d("getLocal", "${itemsLocal.value}")
                }
            } catch (e: Exception) {
                Log.d("getLocal", "${e.message}")
            }

        }

    }

    fun insertData(item: List<Item>, db: ItemDatabase?){
        val itemEntityList = item.map(::itemToEntity)
        try {
            CoroutineScope(Dispatchers.IO).launch {
                db!!.itemDao().addItem(itemEntityList)
            }
        } catch (e: Exception) {
            Log.d("insertLocal", "${e.message}")
        }
    }

    fun entityToItem(itemEntity: ItemEntity): Item {
        return Item(
            itemEntity.id,
            itemEntity.email,
            itemEntity.firstName,
            itemEntity.lastName,
            itemEntity.isRemoved,
            itemEntity.description,
            itemEntity.image)
    }
    fun itemToEntity(item: Item): ItemEntity {
        return ItemEntity(
            item.id,
            false,
            item.email,
            item.firstName,
            item.lastName,
            item.isRemoved,
            item.description,
            item.image)

    }

}