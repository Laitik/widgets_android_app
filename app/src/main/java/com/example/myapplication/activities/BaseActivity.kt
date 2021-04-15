package com.example.myapplication.activities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

open class BaseActivity: FragmentActivity() {

    fun addFragmentToStack(fragmentManager: FragmentManager, fragment: Fragment, id: Int, tag: String) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(id, fragment, tag)
        fragmentTransaction.commit()
    }
}