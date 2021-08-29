package com.example.presentation.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core.fragments.BaseFragment
import com.example.domain.models.PokemonModel
import com.example.presentation.R
import com.example.presentation.databinding.FmtPokemonListBinding
import com.example.presentation.inflate
import com.example.presentation.viewmodel.PokemonListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonsListFragment : BaseFragment() {

    private lateinit var viewBinding: FmtPokemonListBinding
    private val pokemonListViewModel: PokemonListViewModel by viewModel()
    private var adapter: PokemonListAdapter = PokemonListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FmtPokemonListBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.list.adapter = adapter

        pokemonListViewModel.pokemonList.observe(
            viewLifecycleOwner,
            { adapter.refreshList(it) },
        )
    }

    class PokemonListAdapter : RecyclerView.Adapter<PokemonViewHolder>() {

        private val items: MutableList<PokemonModel> = mutableListOf()

        @SuppressLint("NotifyDataSetChanged")
        fun refreshList(newItems: List<PokemonModel>) {
            items.clear()
            items.addAll(newItems)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
            val itemView = parent.inflate(R.layout.item_pokemon, parent)
            return PokemonViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount() = items.count()
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: PokemonModel) {
            itemView.findViewById<TextView>(R.id.name).text = pokemon.name
        }
    }

    companion object {
        const val TAG = "PokemonsListFragment"
    }
}