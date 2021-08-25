package com.dicoding.mypremierleague.core.domain.usecase

import com.dicoding.mypremierleague.core.data.Resource
import com.dicoding.mypremierleague.core.domain.model.MatchResult
import com.dicoding.mypremierleague.core.domain.model.Standing
import kotlinx.coroutines.flow.Flow

interface MyPremierLeagueUseCase {

    fun getStandingLeague(season: String): Flow<Resource<List<Standing>>>

    fun getMatchResult(): Flow<Resource<List<MatchResult>>>
}