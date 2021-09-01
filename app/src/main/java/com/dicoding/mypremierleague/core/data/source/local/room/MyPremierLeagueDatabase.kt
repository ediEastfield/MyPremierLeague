package com.dicoding.mypremierleague.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.mypremierleague.core.data.source.local.entity.LeagueEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.MatchResultEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.StandingEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.TeamEntity

@Database(
    entities = [
        StandingEntity::class,
        MatchResultEntity::class,
        TeamEntity::class,
        LeagueEntity::class,
               ],
    version = 1,
    exportSchema = false
)
abstract class MyPremierLeagueDatabase : RoomDatabase() {

    abstract fun myPremierLeagueDao(): MyPremierLeagueDao

}