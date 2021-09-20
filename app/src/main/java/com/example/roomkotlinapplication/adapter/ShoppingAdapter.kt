package com.example.roomkotlinapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomkotlinapplication.R
import com.example.roomkotlinapplication.data.entities.ShoppingItem
import com.example.roomkotlinapplication.ui.shoppinglist.ShoppingViewModel

class ShoppingAdapter(var itemList: List<ShoppingItem>, var viewModel: ShoppingViewModel) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_shopping_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        var item = itemList.get(position)
        holder.tv_name.text = item.name
        holder.tv_amount.text = item.amount.toString()

        holder.iv_plus.setOnClickListener {
            item.amount++
            viewModel.upSet(item)
        }

        holder.iv_minus.setOnClickListener {
            if (item.amount > 0) {
                item.amount--
                viewModel.upSet(item)
            }

        }

        holder.iv_remove.setOnClickListener {
            viewModel.deleteItem(item)
        }


    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    lateinit var tv_name: TextView
    lateinit var tv_amount: TextView
    lateinit var iv_plus: ImageView
    lateinit var iv_minus: ImageView
    lateinit var iv_remove: ImageView

    init {
        tv_name = itemView.findViewById(R.id.tv_name)
        tv_amount = itemView.findViewById(R.id.tv_amount)
        iv_minus = itemView.findViewById(R.id.iv_minus)
        iv_plus = itemView.findViewById(R.id.iv_plus)
        iv_remove = itemView.findViewById(R.id.iv_remove)
    }


}