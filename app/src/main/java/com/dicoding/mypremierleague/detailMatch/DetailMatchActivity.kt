package com.dicoding.mypremierleague.detailMatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.mypremierleague.core.domain.model.MatchResult
import com.dicoding.mypremierleague.databinding.ActivityDetailMatchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMatchActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_Data"
    }

    private lateinit var binding: ActivityDetailMatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f

        val detailMatch = intent.getParcelableExtra<MatchResult>(EXTRA_DATA)
        showDetailMatch(detailMatch)

    }

    private fun showDetailMatch(detailMatch: MatchResult?) {
        detailMatch?.let {
            supportActionBar?.title = detailMatch.event
            binding.tvMatchDate.text = detailMatch.dateEvent
            binding.tvMatchVenue.text = detailMatch.venue
            binding.tvMatchStatus.text = detailMatch.status
            binding.tvMatchHomeScore.text = detailMatch.homeScore
            binding.tvMatchAwayScore.text = detailMatch.awayScore
            Glide.with(this)
                .load(detailMatch.thumb)
                .into(binding.ivMatchThumb)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}