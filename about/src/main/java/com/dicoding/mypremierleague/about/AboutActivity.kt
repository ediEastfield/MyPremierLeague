package com.dicoding.mypremierleague.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.dicoding.mypremierleague.about.databinding.ActivityAboutBinding
import com.dicoding.mypremierleague.core.data.Resource
import com.dicoding.mypremierleague.core.domain.model.League
import com.dicoding.mypremierleague.di.AboutModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class AboutActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val aboutViewModel: AboutViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAboutComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    AboutModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        aboutViewModel.getDetailLeague.observe(this, { league ->
            if (league != null) {
                when (league) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        league.data?.map { data ->
                            showLeague(data)
                        }
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = league.message
                    }
                }
            }
        })
    }

    private fun showLeague(leagueData: League) {
        leagueData.let {
            binding.tvLeagueName.text = leagueData.league
            Glide.with(this)
                .load(leagueData.badge)
                .into(binding.ivLeagueBadge)
            binding.tvLeagueDescription.text = leagueData.description
            Glide.with(this)
                .load(leagueData.trophy)
                .into(binding.ivLeagueTrophy)
            Glide.with(this)
                .load(leagueData.fanart)
                .into(binding.ivLeagueFanArt)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}