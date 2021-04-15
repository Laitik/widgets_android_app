package com.example.myapplication.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.entity.Widget
import com.example.myapplication.view.WidgetRecyclerView
import com.example.myapplication.view.adapters.WidgetRecyclerViewAdapter
import com.example.myapplication.viewmodel.WidgetViewModel

class ListWidgets: Fragment() {
    private lateinit var tv: TextView
    private lateinit var rv: WidgetRecyclerView
    private lateinit var rv_adapter: WidgetRecyclerViewAdapter

    private val viewModel: WidgetViewModel by lazy { ViewModelProviders.of(this).get(WidgetViewModel::class.java) }
    private val widgetDataObserver = Observer<List<Widget>?> {  it?.let { showData(it) } }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.fragment_main, container, false)

        tv = v.findViewById(R.id.tv)
        rv = v.findViewById(R.id.recycler)
        rv_adapter = WidgetRecyclerViewAdapter()
        rv.adapter = rv_adapter

        viewModel.getItems().observe(this, widgetDataObserver)

        return v
    }

    fun showData(data: List<Widget>) {
        rv_adapter.setItems(data)
        tv.setText(" Всего виджетов: " + data.size)
    }

    override fun onDetach() {
        viewModel.getItems().removeObserver(widgetDataObserver)
        super.onDetach()
    }
}