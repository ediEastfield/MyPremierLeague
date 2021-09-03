package com.dicoding.mypremierleague.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase

class FavoriteViewModel (myPremierLeagueUseCase: MyPremierLeagueUseCase) : ViewModel() {
    val favoriteTeam = myPremierLeagueUseCase.getFavoriteTeam().asLiveData()
}