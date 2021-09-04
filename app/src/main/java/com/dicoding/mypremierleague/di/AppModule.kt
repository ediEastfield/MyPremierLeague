package com.dicoding.mypremierleague.di

import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueInteractor
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideMyPremierLeagueUseCase(myPremierLeagueInteractor: MyPremierLeagueInteractor): MyPremierLeagueUseCase
}