package com.example.myapplication.presentation.view.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.example.myapplication.R
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.presentation.base.holder.WidgetBaseVH
import com.example.myapplication.util.UtilGlide

class WidgetVH(itemView: View): WidgetBaseVH(itemView = itemView) {

    override fun bind(model: Widget) {
        with(itemView) {
            val tv = findViewById<TextView>(R.id.name)
            val avatar = findViewById<ImageView>(R.id.widget_avatar)

            tv.text = model.descr
            UtilGlide.displayImage(avatar, model.avatarUrl)
        }
    }

    companion object {
        @LayoutRes
        const val LAYOUT_RES = R.layout.item_widget
    }

}