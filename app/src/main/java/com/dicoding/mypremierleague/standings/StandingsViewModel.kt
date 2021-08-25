package com.dicoding.mypremierleague.standings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(private val myPremierLeagueUseCase: MyPremierLeagueUseCase) : ViewModel() {
    fun standingLeague(season: String) = myPremierLeagueUseCase.getStandingLeague(season).asLiveData()
}