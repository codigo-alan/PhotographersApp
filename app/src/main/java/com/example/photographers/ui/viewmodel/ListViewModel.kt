package com.example.photographers.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photographers.domain.model.Item

class ListViewModel : ViewModel() {

    private val _mockedItem = Item(1, "Mocked One")

    private val _items = MutableLiveData<List<Item>>().apply { value = List<Item>(10){_mockedItem} }
    val items: LiveData<List<Item>> = _items

    private val _selectedItem = MutableLiveData<Item>()
    val selectedItem: LiveData<Item> = _selectedItem

    fun setSelectedItem(clickedItem: Item){
        _selectedItem.postValue(clickedItem)
    }

}