package com.example.myapplication.activities

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R
import com.example.myapplication.screen.ListWidgets

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager: FragmentManager = supportFragmentManager
        var fragment: ListWidgets? = manager.findFragmentByTag(ListWidgets::class.simpleName) as ListWidgets?
        if (fragment == null)    fragment = ListWidgets()
        addFragmentToStack( manager, fragment, R.id.root_activity_create, ListWidgets::class.simpleName!!)
    }

}