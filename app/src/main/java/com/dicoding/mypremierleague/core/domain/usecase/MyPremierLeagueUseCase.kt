package com.dicoding.mypremierleague.core.domain.usecase

import com.dicoding.mypremierleague.core.data.Resource
import com.dicoding.mypremierleague.core.domain.model.MatchResult
import com.dicoding.mypremierleague.core.domain.model.Standing
import com.dicoding.mypremierleague.core.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface MyPremierLeagueUseCase {
    fun getStandingLeague(season: String): Flow<Resource<List<Standing>>>
    fun getMatchResult(round: String, season: String): Flow<Resource<List<MatchResult>>>
    fun getDetailTeam(teamId: String): Flow<Resource<List<Team>>>
    fun getFavoriteTeam(): Flow<List<Team>>
    fun setFavoriteTeam(team: Team, state: Boolean)
}