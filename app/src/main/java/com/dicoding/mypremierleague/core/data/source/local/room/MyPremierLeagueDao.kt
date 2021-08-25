package com.dicoding.mypremierleague.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.mypremierleague.core.data.source.local.entity.MatchResultEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.StandingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MyPremierLeagueDao {

    @Query("SELECT * FROM standing ORDER BY cast(rank as unsigned) ASC")
    fun getStandingLeague(): Flow<List<StandingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStandingLeague(standingLeague: List<StandingEntity>)

    @Query("SELECT * FROM matchResult ORDER BY dateEvent ASC")
    fun getMatchResults(): Flow<List<MatchResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatchResult(matchResult: List<MatchResultEntity>)

}