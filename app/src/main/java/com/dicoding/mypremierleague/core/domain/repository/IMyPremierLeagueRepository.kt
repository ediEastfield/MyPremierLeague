package com.dicoding.mypremierleague.core.domain.repository

import com.dicoding.mypremierleague.core.data.Resource
import com.dicoding.mypremierleague.core.domain.model.MatchResult
import com.dicoding.mypremierleague.core.domain.model.Standing
import kotlinx.coroutines.flow.Flow

interface IMyPremierLeagueRepository {

    fun getStandingLeague(season: String): Flow<Resource<List<Standing>>>

    fun getMatchResult(): Flow<Resource<List<MatchResult>>>

}