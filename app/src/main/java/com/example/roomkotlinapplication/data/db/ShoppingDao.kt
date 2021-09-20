package com.example.roomkotlinapplication.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomkotlinapplication.data.entities.ShoppingItem

@Dao
interface ShoppingDao {

    //Don't use suspend in Dao


    @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun upSet(shoppingItem: ShoppingItem)

    @Delete
      fun deleteItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>

}