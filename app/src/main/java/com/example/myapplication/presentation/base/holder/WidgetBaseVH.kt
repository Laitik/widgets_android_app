package com.example.myapplication.presentation.base.holder

import android.view.View
import com.example.myapplication.domain.entity.Widget

abstract class WidgetBaseVH (itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView)  {
    abstract fun bind(model: Widget)
}