package com.example.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.presentation.databinding.AcRootBinding
import com.example.presentation.view.FavoritePokemonsListFragment
import com.example.presentation.view.PokemonsListFragment

class RootActivity : AppCompatActivity() {

    private lateinit var viewBinding: AcRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewBinding()
        initAppBar()
        initFragmentHost()
        initBottomNavBar()
    }

    private fun initViewBinding() {
        viewBinding = AcRootBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)
    }

    private fun initAppBar() {}

    private fun initFragmentHost() = openPokemonsList()

    private fun openPokemonsList() = openFragment(PokemonsListFragment())

    private fun openFavoritesPokemonsList() = openFragment(FavoritePokemonsListFragment())

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_host, fragment)
        transaction.commit()
    }

    private fun initBottomNavBar() {
        viewBinding.bottomNavBar.apply {
            inflateMenu(R.menu.main_nav_menu)
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.list -> {
                        openPokemonsList()
                        true
                    }
                    R.id.favorite -> {
                        openFavoritesPokemonsList()
                        true
                    }
                    else -> false
                }
            }
        }
    }
}