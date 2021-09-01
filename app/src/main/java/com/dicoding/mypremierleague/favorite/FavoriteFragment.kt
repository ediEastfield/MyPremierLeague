package com.dicoding.mypremierleague.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mypremierleague.core.ui.FavoriteAdapter
import com.dicoding.mypremierleague.databinding.FragmentFavoriteBinding
import com.dicoding.mypremierleague.team.TeamActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val favoriteAdapter = FavoriteAdapter()
            favoriteAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, TeamActivity::class.java)
                intent.putExtra(TeamActivity.EXTRA_DATA, selectedData.teamId)
                startActivity(intent)
            }

            favoriteViewModel.favoriteTeam.observe(viewLifecycleOwner, { favorite ->
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}