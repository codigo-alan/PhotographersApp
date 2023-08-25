package com.example.photographers.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photographers.data.local.LocalDataSource
import com.example.photographers.data.remote.RemoteDataSource
import com.example.photographers.data.repository.Repository
import com.example.photographers.domain.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel : ViewModel() {
    private val _localDataSource = LocalDataSource()
    private val _remoteDataSource = RemoteDataSource()
    private val _repository = Repository(_remoteDataSource, _localDataSource)

    /*private val _mockedItem = Item(
        id = 1,
        guid = "some-guid-value",
        email = "example@email.com",
        firstName = "John",
        lastName = "Doe",
        isRemoved = false,
        description = "Description goes here",
        avatar = "https://example.com/avatar.jpg",
        image = "https://example.com/image.jpg",
        facebook = "https://facebook.com/johndoe",
        instagram = "https://instagram.com/johndoe",
        webpage = "https://johndoe.com"
    )

    private val _items = MutableLiveData<List<Item>>().apply { value = List<Item>(10){_mockedItem} }
    val items: LiveData<List<Item>> = _items*/

    private val _items = MutableLiveData<List<Item>>().apply { value = listOf() }
    val items: LiveData<List<Item>> = _items

    private val _selectedItem = MutableLiveData<Item>()
    val selectedItem: LiveData<Item> = _selectedItem

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _repository.fetchData() //fetch data from repo
            }
            _items.postValue(_repository.items.value) //set items with the modified value from repo
        }
    }

    fun setSelectedItem(clickedItem: Item){
        _selectedItem.postValue(clickedItem)
    }

}