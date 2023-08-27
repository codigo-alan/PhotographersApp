package com.example.photographers.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photographers.data.local.ItemDatabase
import com.example.photographers.data.repository.Repository
import com.example.photographers.domain.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel : ViewModel() {
    val repository = Repository()

    private val _items = MutableLiveData<List<Item>>().apply { value = listOf() }
    val items: LiveData<List<Item>> = _items

    private val _selectedItem = MutableLiveData<Item>()
    val selectedItem: LiveData<Item> = _selectedItem

    init {
        remoteFetchData()
    }

    private fun remoteFetchData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.remoteFetchData() //fetch data from repo
            }
            //_items.postValue(repository.remoteDataSource.itemsRemote.value) //TODO delete this line
        }
    }

     fun localFetchData() {
        /*viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.localFetchData(db) //fetch data from db
            }
            _items.postValue(repository.localDataSource.itemsLocal.value) //set items with the modified value from db
        }*/
         _items.postValue(repository.localDataSource.itemsLocal.value)
    }

    fun saveDataLocal(itemList: List<Item>, db: ItemDatabase?) {
        repository.localSaveFetchData(itemList, db)
    }

    fun setSelectedItem(clickedItem: Item){
        _selectedItem.postValue(clickedItem)
    }


}