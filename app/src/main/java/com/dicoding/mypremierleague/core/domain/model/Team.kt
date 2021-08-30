package com.dicoding.mypremierleague.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val teamId: String,
    val teamBadge: String,
    val team: String,
    val keywords: String,
    val formedYear: String,
    val instagram: String,
    val website: String,
    val youtube: String,
    val twitter: String,
    val facebook: String,
    val description: String,
    val stadiumThumb: String,
    val stadium: String,
    val stadiumCapacity: String,
    val stadiumLocation: String,
    val stadiumDescription: String,
    val teamJersey: String,
    val teamBanner: String,
    val isFavorite: Boolean
): Parcelable
