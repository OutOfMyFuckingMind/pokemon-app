package com.example.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.core.activity.BottomBarVisibilityManager
import com.example.presentation.R
import com.example.presentation.databinding.AcRootBinding
import com.example.presentation.view.fragments.FavoritePokemonsListFragment
import com.example.presentation.view.fragments.PokemonsListFragment

class RootActivity : AppCompatActivity(), BottomBarVisibilityManager {

    private lateinit var viewBinding: AcRootBinding

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

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

    override fun hideBottomNavBar() {
        viewBinding.root.transitionToEnd()
    }

    override fun showBottomNavBar() {
        viewBinding.root.transitionToStart()
    }

    private fun initAppBar() {}

    private fun initFragmentHost() = openPokemonsList()

    private fun openPokemonsList() = openFragment(PokemonsListFragment())

    private fun openFavoritesPokemonsList() = openFragment(FavoritePokemonsListFragment())

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_host, fragment)
        transaction.commit()
        transaction.addToBackStack(fragment.toString())
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