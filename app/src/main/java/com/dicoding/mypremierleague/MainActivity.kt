package com.dicoding.mypremierleague

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.dicoding.mypremierleague.about.AboutFragment
import com.dicoding.mypremierleague.databinding.ActivityMainBinding
import com.dicoding.mypremierleague.favorite.FavoriteFragment
import com.dicoding.mypremierleague.matchResults.MatchResultsFragment
import com.dicoding.mypremierleague.standings.StandingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.drawerNav.setNavigationItemSelectedListener(this)
        binding.appBarMain.contentMain.navView.setOnNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, StandingsFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = StandingsFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_favorite -> {
                fragment = FavoriteFragment()
                title = getString(R.string.menu_favorite)
            }
            R.id.nav_about -> {
                fragment = AboutFragment()
                title = getString(R.string.menu_about)
            }
            R.id.nav_standings -> {
                fragment = StandingsFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_match_results -> {
                fragment = MatchResultsFragment()
                title = getString(R.string.app_name)
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}