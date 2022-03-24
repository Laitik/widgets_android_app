package com.example.myapplication.presentation.base.adapter

import androidx.recyclerview.widget.DiffUtil

class RecyclerDiffUtil<ITEM>(
    private val oldList: List<ITEM>,
    private val newList: List<ITEM>
) :
    DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}