package com.example.myapplication.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.presentation.base.adapter.RecyclerAdapter
import com.example.myapplication.presentation.base.holder.WidgetBaseVH

class WidgetRecyclerViewAdapter :  RecyclerAdapter<Widget, WidgetBaseVH>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): WidgetBaseVH {
        val inflater = LayoutInflater.from(viewGroup.context)
        return WidgetVH(inflater.inflate(WidgetVH.LAYOUT_RES,viewGroup,false))
    }

    override fun onBindViewHolder(viewHolder: WidgetBaseVH, position: Int) {
        viewHolder.bind(getItem(position))
    }
}