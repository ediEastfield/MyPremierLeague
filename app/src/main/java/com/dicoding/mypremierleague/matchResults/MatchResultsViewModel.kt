package com.dicoding.mypremierleague.matchResults

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MatchResultsViewModel @Inject constructor(private val myPremierLeagueUseCase: MyPremierLeagueUseCase) : ViewModel() {
    fun matchResults(round: String, season: String) = myPremierLeagueUseCase.getMatchResult(round, season).asLiveData()
}