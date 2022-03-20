package com.example.myapplication.presentation.base.adapter

abstract class RecyclerAdapter<ITEM, VH : androidx.recyclerview.widget.RecyclerView.ViewHolder> :
    androidx.recyclerview.widget.RecyclerView.Adapter<VH>() {

    private val items = mutableListOf<ITEM>()

    fun setItems(mutableList: List<ITEM>) {
        items.clear()
        items.addAll(mutableList)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): ITEM = items[position]

    protected fun getItems(): List<ITEM> = items

    override fun getItemCount(): Int = items.size

    fun removeAll() = items.clear()
}