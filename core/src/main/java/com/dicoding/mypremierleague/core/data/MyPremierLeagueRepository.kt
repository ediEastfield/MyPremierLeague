package com.dicoding.mypremierleague.core.data

import com.dicoding.mypremierleague.core.data.source.local.LocalDataSource
import com.dicoding.mypremierleague.core.data.source.remote.RemoteDataSource
import com.dicoding.mypremierleague.core.data.source.remote.network.ApiResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.LeagueResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.MatchResultResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.StandingResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.TeamResponse
import com.dicoding.mypremierleague.core.domain.model.League
import com.dicoding.mypremierleague.core.domain.model.MatchResult
import com.dicoding.mypremierleague.core.domain.model.Standing
import com.dicoding.mypremierleague.core.domain.model.Team
import com.dicoding.mypremierleague.core.domain.repository.IMyPremierLeagueRepository
import com.dicoding.mypremierleague.core.utils.AppExecutors
import com.dicoding.mypremierleague.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyPremierLeagueRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMyPremierLeagueRepository {

    override fun getStandingLeague(season: String): Flow<Resource<List<Standing>>> =
        object : NetworkBoundResource<List<Standing>, List<StandingResponse>>() {
            override fun loadFromDB(): Flow<List<Standing>> {
                return localDataSource.getStandingLeague().map {
                    DataMapper.mapStandingEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Standing>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<StandingResponse>>> =
                remoteDataSource.getStandingLeague(season)

            override suspend fun saveCallResult(data: List<StandingResponse>) {
                val standingLeagueList = DataMapper.mapStandingResponsesToEntities(data)
                localDataSource.insertStandingLeague(standingLeagueList)
            }
        }.asFlow()

    override fun getMatchResult(round: String, season: String): Flow<Resource<List<MatchResult>>> =
        object : NetworkBoundResource<List<MatchResult>, List<MatchResultResponse>>() {
            override fun loadFromDB(): Flow<List<MatchResult>> {
                return localDataSource.getMatchResults(round).map {
                    DataMapper.mapMatchResultEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MatchResult>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<MatchResultResponse>>> =
                remoteDataSource.getMatchResults(round, season)

            override suspend fun saveCallResult(data: List<MatchResultResponse>) {
                localDataSource.deleteStandingLeague()
                val matchResultList = DataMapper.mapEventResponsesToEntities(data)
                localDataSource.insertMatchResults(matchResultList)
            }
        }.asFlow()

    override fun getDetailTeam(teamId: String): Flow<Resource<List<Team>>> =
        object : NetworkBoundResource<List<Team>, List<TeamResponse>>() {
            override fun loadFromDB(): Flow<List<Team>> {
                return localDataSource.getDetailTeam(teamId). map {
                    DataMapper.mapTeamEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Team>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TeamResponse>>> =
                remoteDataSource.getDetailTeam(teamId)

            override suspend fun saveCallResult(data: List<TeamResponse>) {
                val teamList = DataMapper.mapTeamResponsesToEntities(data)
                localDataSource.insertTeam(teamList)
            }
        }.asFlow()

    override fun getFavoriteTeam(): Flow<List<Team>> {
        return localDataSource.getFavoriteTeam().map {
            DataMapper.mapTeamEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTeam(team: Team, state: Boolean) {
        val teamEntity = DataMapper.mapTeamDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTeam(teamEntity, state) }
    }

    override fun getDetailLeague(): Flow<Resource<List<League>>> =
        object : NetworkBoundResource<List<League>, List<LeagueResponse>>() {
            override fun loadFromDB(): Flow<List<League>> {
                return localDataSource.getDetailLeague().map {
                    DataMapper.mapLeagueEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<League>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<LeagueResponse>>> =
                remoteDataSource.getDetailLeague()

            override suspend fun saveCallResult(data: List<LeagueResponse>) {
                val leagueList = DataMapper.mapLeagueResponsesToEntities(data)
                localDataSource.insertLeague(leagueList)
            }
        }.asFlow()

}