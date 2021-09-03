package com.dicoding.mypremierleague.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val myPremierLeagueUseCase: MyPremierLeagueUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(myPremierLeagueUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}