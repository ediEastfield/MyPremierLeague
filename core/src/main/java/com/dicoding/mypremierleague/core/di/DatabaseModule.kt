package com.dicoding.mypremierleague.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.mypremierleague.core.data.source.local.room.MyPremierLeagueDao
import com.dicoding.mypremierleague.core.data.source.local.room.MyPremierLeagueDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MyPremierLeagueDatabase = Room.databaseBuilder(
        context,
        MyPremierLeagueDatabase::class.java,
        "MyFootball.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMyPremierLeagueDao(database: MyPremierLeagueDatabase): MyPremierLeagueDao = database.myPremierLeagueDao()
}