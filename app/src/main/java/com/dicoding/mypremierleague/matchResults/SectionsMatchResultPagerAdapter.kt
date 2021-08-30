package com.dicoding.mypremierleague.matchResults

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsMatchResultPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return MatchweekResultsFragment.newInstance(position + 1)
    }

    override fun getItemCount(): Int = 38

}