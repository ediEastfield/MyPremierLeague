package com.dicoding.mypremierleague.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(private val myPremierLeagueUseCase: MyPremierLeagueUseCase) : ViewModel() {
    fun getDetailLeague() = myPremierLeagueUseCase.getDetailLeague().asLiveData()
}