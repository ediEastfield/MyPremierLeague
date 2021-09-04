package com.dicoding.mypremierleague.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase

class AboutViewModel(myPremierLeagueUseCase: MyPremierLeagueUseCase) : ViewModel() {
    val getDetailLeague = myPremierLeagueUseCase.getDetailLeague().asLiveData()
}