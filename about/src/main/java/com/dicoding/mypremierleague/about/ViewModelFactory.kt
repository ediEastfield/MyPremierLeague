package com.dicoding.mypremierleague.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.mypremierleague.core.domain.usecase.MyPremierLeagueUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val myPremierLeagueUseCase: MyPremierLeagueUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(AboutViewModel::class.java) -> {
                AboutViewModel(myPremierLeagueUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}