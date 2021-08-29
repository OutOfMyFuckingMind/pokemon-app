package com.example.core.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.core.activity.BottomBarVisibilityManager

open class BaseFragment : Fragment() {

    protected var bottomBarVisibilityManager: BottomBarVisibilityManager? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (activity != null && activity is BottomBarVisibilityManager) {
            bottomBarVisibilityManager = activity as BottomBarVisibilityManager
        }
    }
}