package com.dicoding.mypremierleague.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.mypremierleague.core.domain.model.Team
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(private val myPremierLeagueUseCase: MyPremierLeagueUseCase) : ViewModel() {
    fun getDetailTeam(teamId: String) = myPremierLeagueUseCase.getDetailTeam(teamId).asLiveData()
    fun setFavoriteTeam(team: Team, newStatus: Boolean) = myPremierLeagueUseCase.setFavoriteTeam(team, newStatus)
}