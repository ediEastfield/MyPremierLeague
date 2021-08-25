package com.dicoding.mypremierleague.core.di

import com.dicoding.mypremierleague.core.data.MyPremierLeagueRepository
import com.dicoding.mypremierleague.core.domain.repository.IMyPremierLeagueRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(myPremierLeagueRepository: MyPremierLeagueRepository): IMyPremierLeagueRepository
}