package com.example.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.presentation.databinding.FmtFavoritePokemonListBinding

class FavoritePokemonsListFragment : Fragment() {

    private lateinit var viewBinding: FmtFavoritePokemonListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FmtFavoritePokemonListBinding.inflate(inflater)
        return viewBinding.root
    }
}