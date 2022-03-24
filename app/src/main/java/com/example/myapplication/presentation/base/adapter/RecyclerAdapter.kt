package com.example.myapplication.presentation.base.adapter

import androidx.recyclerview.widget.DiffUtil

abstract class RecyclerAdapter<ITEM, VH : androidx.recyclerview.widget.RecyclerView.ViewHolder> :
    androidx.recyclerview.widget.RecyclerView.Adapter<VH>() {

    var items = emptyList<ITEM>()
        set(value) {
            val callback = RecyclerDiffUtil(field, value)
            field = value
            DiffUtil.calculateDiff(callback).dispatchUpdatesTo(this)
        }


    fun getItem(position: Int): ITEM = items[position]

    override fun getItemCount(): Int = items.size
}

