package com.dicoding.mypremierleague.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.mypremierleague.core.data.source.local.entity.MatchResultEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.StandingEntity

@Database(
    entities = [
        StandingEntity::class,
        MatchResultEntity::class,
               ],
    version = 1,
    exportSchema = false
)
abstract class MyPremierLeagueDatabase : RoomDatabase() {

    abstract fun myPremierLeagueDao(): MyPremierLeagueDao

}