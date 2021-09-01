package com.dicoding.mypremierleague.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.dicoding.mypremierleague.R
import com.dicoding.mypremierleague.core.data.Resource
import com.dicoding.mypremierleague.core.domain.model.League
import com.dicoding.mypremierleague.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : Fragment() {

    private val aboutViewModel: AboutViewModel by viewModels()

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            aboutViewModel.getDetailLeague().observe(viewLifecycleOwner, { league ->
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
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = league.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}