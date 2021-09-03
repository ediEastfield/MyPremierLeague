package com.dicoding.mypremierleague.core.domain.usecase

import com.dicoding.mypremierleague.core.domain.model.Team
import com.dicoding.mypremierleague.core.domain.repository.IMyPremierLeagueRepository
import javax.inject.Inject

class MyPremierLeagueInteractor @Inject constructor(private val myPremierLeagueRepository: IMyPremierLeagueRepository) : MyPremierLeagueUseCase {

    override fun getStandingLeague(season: String) = myPremierLeagueRepository.getStandingLeague(season)
    override fun getMatchResult(round: String, season: String) = myPremierLeagueRepository.getMatchResult(round, season)
    override fun getDetailTeam(teamId: String) = myPremierLeagueRepository.getDetailTeam(teamId)
    override fun getFavoriteTeam() = myPremierLeagueRepository.getFavoriteTeam()
    override fun setFavoriteTeam(team: Team, state: Boolean) = myPremierLeagueRepository.setFavoriteTeam(team, state)
    override fun getDetailLeague() = myPremierLeagueRepository.getDetailLeague()

}