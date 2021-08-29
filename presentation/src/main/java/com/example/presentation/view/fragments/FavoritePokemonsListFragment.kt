package com.example.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.fragments.BaseFragment
import com.example.presentation.databinding.FmtFavoritePokemonListBinding

class FavoritePokemonsListFragment : BaseFragment() {

    private lateinit var viewBinding: FmtFavoritePokemonListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FmtFavoritePokemonListBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomBarVisibilityManager?.hideBottomNavBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bottomBarVisibilityManager?.showBottomNavBar()
    }
}