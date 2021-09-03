package com.dicoding.mypremierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListLeagueResponse(

    @field:SerializedName("leagues")
    val leagues: List<LeagueResponse>
)
