package com.example.photographers.data.local

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.photographers.data.local.model.ItemEntity
import com.example.photographers.domain.model.Item
import kotlinx.coroutines.*

class LocalDataSource() {

    var itemsLocal = MutableLiveData<List<Item>>()

    fun fetchData(db: ItemDatabase?) {

        CoroutineScope(Dispatchers.IO).launch {

            try {
                val itemsTemp = db!!.itemDao().getItems().map(::entityToItem)
                withContext(Dispatchers.Main) {
                    itemsLocal.postValue(itemsTemp)
                    Log.d("get local", "${itemsLocal.value}")
                }
            } catch (e: Exception) {
                Log.d("get local", "${e}")
            }

        }

    }

    fun insertItemsList(item: List<Item>, db: ItemDatabase?){
        val itemEntityList = item.map(::itemToEntity)
        CoroutineScope(Dispatchers.IO).launch {
            db!!.itemDao().addItem(itemEntityList)
            val itemsTemp = db!!.itemDao().getItems().map(::entityToItem)
            withContext(Dispatchers.Main) {
                itemsLocal.postValue(itemsTemp)
                Log.d("get local", "${itemsLocal.value}")
            }
        }



        /*try {
            val itemEntityList = item.map(::itemToEntity)
            ItemApplication.database.itemDao().addItem(itemEntityList)
            Log.d("insert local data", "${itemsLocal.value}")
        } catch (e: Exception) {
            Log.d("insert local data", "$e")
        }*/
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
    private fun itemToEntity(item: Item): ItemEntity {
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