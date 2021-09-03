package com.dicoding.mypremierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LeagueResponse(

    @field:SerializedName("strDescriptionEN")
    val description: String,

    @field:SerializedName("idLeague")
    val leagueId: String,

    @field:SerializedName("strTrophy")
    val trophy: String,

    @field:SerializedName("strBadge")
    val badge: String,

    @field:SerializedName("strFanart1")
    val fanart: String,

    @field:SerializedName("strLeague")
    val league: String,

    @field:SerializedName("strCurrentSeason")
    val currentSeason: String

)
