package com.dicoding.mypremierleague.di

import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun myPremiereLeagueUseCase(): MyPremierLeagueUseCase
}