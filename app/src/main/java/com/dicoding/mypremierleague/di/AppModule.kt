package com.dicoding.mypremierleague.di

import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueInteractor
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideMyPremierLeagueUseCase(myPremierLeagueInteractor: MyPremierLeagueInteractor): MyPremierLeagueUseCase
}