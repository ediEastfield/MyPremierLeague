package com.dicoding.mypremierleague.core.data.source.local

import com.dicoding.mypremierleague.core.data.source.local.entity.LeagueEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.MatchResultEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.StandingEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.TeamEntity
import com.dicoding.mypremierleague.core.data.source.local.room.MyPremierLeagueDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val myPremierLeagueDao: MyPremierLeagueDao) {

    fun getStandingLeague(): Flow<List<StandingEntity>> = myPremierLeagueDao.getStandingLeague()

    suspend fun insertStandingLeague(standingLeagueList: List<StandingEntity>) = myPremierLeagueDao.insertStandingLeague(standingLeagueList)

    fun getMatchResults(round: String): Flow<List<MatchResultEntity>> = myPremierLeagueDao.getMatchResults(round)

    suspend fun insertMatchResults(matchResultList: List<MatchResultEntity>) = myPremierLeagueDao.insertMatchResult(matchResultList)

    fun getDetailTeam(teamId: String): Flow<List<TeamEntity>> = myPremierLeagueDao.getDetailTeam(teamId)

    fun getFavoriteTeam(): Flow<List<TeamEntity>> = myPremierLeagueDao.getFavoriteTeam()

    suspend fun insertTeam(teamList: List<TeamEntity>) = myPremierLeagueDao.insertTeam(teamList)

    fun setFavoriteTeam(team: TeamEntity,newState: Boolean) {
        team.isFavorite = newState
        myPremierLeagueDao.updateFavoriteTeam(team)
    }

    fun getDetailLeague(): Flow<List<LeagueEntity>> = myPremierLeagueDao.getDetailLeague()

    suspend fun insertLeague(leagueList: List<LeagueEntity>) = myPremierLeagueDao.insertDetailLeague(leagueList)

}