package com.example.myapplication.presentation.activities

import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.presentation.base.activity.BaseActivity
import com.example.myapplication.presentation.screen.ListWidgets

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment =
            (supportFragmentManager.findFragmentByTag(ListWidgets::class.simpleName) as? ListWidgets)
                ?: ListWidgets()
        addFragmentToStack(
            supportFragmentManager,
            fragment,
            R.id.root_activity_create,
            ListWidgets::class.simpleName
        )
    }

}