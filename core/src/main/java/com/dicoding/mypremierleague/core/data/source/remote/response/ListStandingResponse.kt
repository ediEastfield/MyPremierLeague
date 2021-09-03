package com.dicoding.mypremierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListStandingResponse(

    @field:SerializedName("table")
    val table: List<StandingResponse>
)
