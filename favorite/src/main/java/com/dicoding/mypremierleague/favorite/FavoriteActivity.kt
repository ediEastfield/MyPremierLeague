package com.dicoding.mypremierleague.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mypremierleague.core.ui.FavoriteAdapter
import com.dicoding.mypremierleague.di.FavoriteModuleDependencies
import com.dicoding.mypremierleague.favorite.databinding.ActivityFavoriteBinding
import com.dicoding.mypremierleague.team.TeamActivity
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val favoriteAdapter = FavoriteAdapter()
        favoriteAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, TeamActivity::class.java)
            intent.putExtra(TeamActivity.EXTRA_DATA, selectedData.teamId)
            startActivity(intent)
        }

        favoriteViewModel.favoriteTeam.observe(this, { favorite ->
            favoriteAdapter.setData(favorite)
            binding.viewEmpty.root.visibility = if (favorite.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvFavoriteTeam) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = favoriteAdapter
        }
    }
}