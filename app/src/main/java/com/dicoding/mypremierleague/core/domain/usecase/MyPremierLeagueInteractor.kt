package com.dicoding.mypremierleague.core.domain.usecase

import com.dicoding.mypremierleague.core.domain.repository.IMyPremierLeagueRepository
import javax.inject.Inject

class MyPremierLeagueInteractor @Inject constructor(private val myPremierLeagueRepository: IMyPremierLeagueRepository) : MyPremierLeagueUseCase {

    override fun getStandingLeague(season: String) = myPremierLeagueRepository.getStandingLeague(season)
    override fun getMatchResult() = myPremierLeagueRepository.getMatchResult()
}