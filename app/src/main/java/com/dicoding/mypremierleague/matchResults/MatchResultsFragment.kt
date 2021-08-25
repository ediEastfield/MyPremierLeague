package com.dicoding.mypremierleague.matchResults

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mypremierleague.R
import com.dicoding.mypremierleague.core.data.Resource
import com.dicoding.mypremierleague.core.ui.MatchResultAdapter
import com.dicoding.mypremierleague.databinding.FragmentMatchResultsBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchResultsFragment : Fragment() {

    private var _binding: FragmentMatchResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMatchResultsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val sectionsPagerAdapter = SectionsMatchResultPagerAdapter(activity as AppCompatActivity)
        binding.viewPager.adapter = sectionsPagerAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}