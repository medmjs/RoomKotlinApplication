package com.example.roomkotlinapplication.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomkotlinapplication.data.entities.ShoppingItem
import com.example.roomkotlinapplication.data.repositories.Repository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingViewModel(var repository: Repository) : ViewModel() {

    public fun upSet(item: ShoppingItem) = GlobalScope.launch {
        repository.upSet(item)
    }

    fun deleteItem(item: ShoppingItem) = GlobalScope.launch {
        repository.deleteItem(item)
    }

    fun getAllItem(): LiveData<List<ShoppingItem>> = repository.getAllItem()

}