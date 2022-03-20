package com.example.myapplication.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.domain.entity.Widget
import com.example.myapplication.getAppContext
import com.example.myapplication.presentation.factories.viewModelFactory
import com.example.myapplication.presentation.view.WidgetRecyclerView
import com.example.myapplication.presentation.view.adapters.WidgetRecyclerViewAdapter

class ListWidgets : Fragment() {
    private var tv: TextView? = null
    private var rv: WidgetRecyclerView? = null
    private var rv_adapter: WidgetRecyclerViewAdapter? = null

    private val viewModel: WidgetViewModel by viewModelFactory(
        creator = {
            WidgetViewModel(
                requireContext().getAppContext().getUserInfo(),
                requireContext().getAppContext().getControllerApi(),
                requireContext().getAppContext().getCashRepository()
            )
        }
    )

    private fun showData(data: List<Widget>) {
        rv_adapter?.setItems(data)
        tv?.setText(" Всего виджетов: " + data.size)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.fragment_main, container, false)

        tv = v.findViewById(R.id.tv)
        rv_adapter = WidgetRecyclerViewAdapter()
        rv = v.findViewById(R.id.recycler)
        rv?.adapter = rv_adapter

        viewModel.itemData.observe(viewLifecycleOwner) {
            it?.let {
                showData(it)
            }
        }

        viewModel.getItems()
        return v
    }
}