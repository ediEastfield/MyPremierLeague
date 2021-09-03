package com.dicoding.mypremierleague.core.data.source.local.room

import androidx.room.*
import com.dicoding.mypremierleague.core.data.source.local.entity.LeagueEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.MatchResultEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.StandingEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MyPremierLeagueDao {

    @Query("SELECT * FROM standing ORDER BY cast(rank as unsigned) ASC")
    fun getStandingLeague(): Flow<List<StandingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStandingLeague(standingLeague: List<StandingEntity>)

    @Query("SELECT * FROM matchResult WHERE round = :round ORDER BY dateEvent ASC")
    fun getMatchResults(round: String): Flow<List<MatchResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatchResult(matchResult: List<MatchResultEntity>)

    @Query("SELECT * FROM team WHERE teamId = :teamId")
    fun getDetailTeam(teamId: String): Flow<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE isFavorite = 1")
    fun getFavoriteTeam(): Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: List<TeamEntity>)

    @Update
    fun updateFavoriteTeam(team: TeamEntity)

    @Query("SELECT * FROM league")
    fun getDetailLeague(): Flow<List<LeagueEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailLeague(detailLeague: List<LeagueEntity>)
}