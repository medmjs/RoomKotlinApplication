package com.example.roomkotlinapplication.data.repositories

import androidx.lifecycle.LiveData
import com.example.roomkotlinapplication.data.db.ShoppingDatabase
import com.example.roomkotlinapplication.data.entities.ShoppingItem

class Repository(private var db: ShoppingDatabase) {



    suspend fun upSet(item:ShoppingItem) = db.getShoppingDao().upSet(item)

    suspend fun deleteItem(item: ShoppingItem) = db.getShoppingDao().deleteItem(item)

    fun getAllItem():LiveData<List<ShoppingItem>> = db.getShoppingDao().getAllShoppingItem()


}