package com.example.myapplication.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.base.adapter.RecyclerAdapter
import com.example.myapplication.base.holder.WidgetBaseVH
import com.example.myapplication.entity.Widget

class WidgetRecyclerViewAdapter :  RecyclerAdapter<Widget, WidgetBaseVH>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): WidgetBaseVH {
        val inflater = LayoutInflater.from(viewGroup.context)
        return WidgetVH(inflater.inflate(WidgetVH.LAYOUT_RES,viewGroup,false))
    }

    override fun onBindViewHolder(viewHolder: WidgetBaseVH, position: Int) {
        viewHolder.bind(getItem(position))
    }
}