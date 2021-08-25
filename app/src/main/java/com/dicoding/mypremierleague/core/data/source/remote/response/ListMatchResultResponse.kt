package com.dicoding.mypremierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMatchResultResponse(

    @field:SerializedName("events")
    val events: List<MatchResultResponse>

)
