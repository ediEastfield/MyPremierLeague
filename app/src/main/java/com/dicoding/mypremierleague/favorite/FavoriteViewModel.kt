package com.dicoding.mypremierleague.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(myPremierLeagueUseCase: MyPremierLeagueUseCase) : ViewModel() {
    val favoriteTeam = myPremierLeagueUseCase.getFavoriteTeam().asLiveData()
}