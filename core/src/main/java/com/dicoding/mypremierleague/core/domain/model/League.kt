package com.dicoding.mypremierleague.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    val leagueId: String,
    val description: String,
    val trophy: String,
    val badge: String,
    val fanart: String,
    val league: String,
    val currentSeason: String
): Parcelable
