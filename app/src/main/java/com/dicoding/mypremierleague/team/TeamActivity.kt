package com.dicoding.mypremierleague.team

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.mypremierleague.R
import com.dicoding.mypremierleague.core.data.Resource
import com.dicoding.mypremierleague.core.domain.model.Standing
import com.dicoding.mypremierleague.core.domain.model.Team
import com.dicoding.mypremierleague.databinding.ActivityTeamBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val teamViewModel: TeamViewModel by viewModels()

    private lateinit var binding: ActivityTeamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val team = intent.getStringExtra(EXTRA_DATA)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        if (team != null) {
            teamViewModel.getDetailTeam(team).observe(this, { teamData ->
                if (teamData != null) {
                    when (teamData) {
                        is Resource.Loading -> binding.contentTeam.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.contentTeam.progressBar.visibility = View.GONE
                            teamData.data?.map { data ->
                                showDetailTeam(data)
                            }
                        }
                        is Resource.Error -> {
                            binding.contentTeam.progressBar.visibility = View.GONE
                            binding.contentTeam.viewError.root.visibility = View.VISIBLE
                            binding.contentTeam.viewError.tvError.text = teamData.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })
        }
    }

    private fun showDetailTeam(teamData: Team) {
        teamData.let {
            supportActionBar?.title = teamData.team

            Glide.with(this)
                .load(teamData.teamBadge)
                .into(binding.contentTeam.cardProfile.ivTeamBadge)
            binding.contentTeam.cardProfile.tvTeamName.text = teamData.team
            binding.contentTeam.cardProfile.tvTeamKeywords.text = teamData.keywords
            binding.contentTeam.cardProfile.tvTeamFormed.text = teamData.formedYear
            binding.contentTeam.cardProfile.tvTeamWebsite.text = teamData.website
            binding.contentTeam.cardProfile.ibTeamFacebook.setOnClickListener { Toast.makeText(this, teamData.facebook, Toast.LENGTH_SHORT).show() }
            binding.contentTeam.cardProfile.ibTeamInstagram.setOnClickListener { Toast.makeText(this, teamData.instagram, Toast.LENGTH_SHORT).show() }
            binding.contentTeam.cardProfile.ibTeamTwitter.setOnClickListener { Toast.makeText(this, teamData.twitter, Toast.LENGTH_SHORT).show() }
            binding.contentTeam.cardProfile.ibTeamYoutube.setOnClickListener { Toast.makeText(this, teamData.youtube, Toast.LENGTH_SHORT).show() }
            binding.contentTeam.cardProfile.tvTeamDescription.text = teamData.description

            Glide.with(this)
                .load(teamData.stadiumThumb)
                .into(binding.contentTeam.cardStadium.ivStadiumBadge)
            binding.contentTeam.cardStadium.tvStadiumName.text = teamData.stadium
            binding.contentTeam.cardStadium.tvStadiumLocation.text = teamData.stadiumLocation
            binding.contentTeam.cardStadium.tvStadiumCapacity.text = teamData.stadiumCapacity
            binding.contentTeam.cardStadium.tvStadiumDescription.text = teamData.stadiumDescription

            Glide.with(this)
                .load(teamData.teamJersey)
                .into(binding.contentTeam.ivTeamJersey)

            Glide.with(this)
                .load(teamData.teamBanner)
                .into(binding.contentTeam.ivTeamBanner)

            var statusFavorite = teamData.isFavorite
            setStatusFavorite(statusFavorite)
            binding.contentTeam.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                teamViewModel.setFavoriteTeam(teamData, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.contentTeam.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.contentTeam.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite_white
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}