package com.example.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.core.fragments.BaseFragment
import com.example.presentation.R
import com.example.presentation.databinding.FmtPokemonBinding

class PokemonFragment : BaseFragment() {

    private lateinit var viewBinding: FmtPokemonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FmtPokemonBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<MotionLayout>(R.id.root)
        bottomBarVisibilityManager?.hideBottomNavBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bottomBarVisibilityManager?.showBottomNavBar()
    }
}