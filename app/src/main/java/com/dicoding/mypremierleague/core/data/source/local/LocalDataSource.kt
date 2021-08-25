package com.dicoding.mypremierleague.core.data.source.local

import com.dicoding.mypremierleague.core.data.source.local.entity.MatchResultEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.StandingEntity
import com.dicoding.mypremierleague.core.data.source.local.room.MyPremierLeagueDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val myPremierLeagueDao: MyPremierLeagueDao) {

    fun getStandingLeague(): Flow<List<StandingEntity>> = myPremierLeagueDao.getStandingLeague()

    suspend fun insertStandingLeague(standingLeagueList: List<StandingEntity>) = myPremierLeagueDao.insertStandingLeague(standingLeagueList)

    fun getMatchResults(): Flow<List<MatchResultEntity>> = myPremierLeagueDao.getMatchResults()

    suspend fun insertMatchResults(matchResultList: List<MatchResultEntity>) = myPremierLeagueDao.insertMatchResult(matchResultList)

}