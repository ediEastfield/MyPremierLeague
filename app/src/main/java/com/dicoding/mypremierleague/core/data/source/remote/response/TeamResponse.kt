package com.dicoding.mypremierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamResponse(

    @field:SerializedName("idTeam")
    val teamId: String,

    @field:SerializedName("strTeamBadge")
    val teamBadge: String,

    @field:SerializedName("strTeam")
    val team: String,

    @field:SerializedName("strKeywords")
    val keywords: String,

    @field:SerializedName("intFormedYear")
    val formedYear: String,

    @field:SerializedName("strInstagram")
    val instagram: String,

    @field:SerializedName("strWebsite")
    val website: String,

    @field:SerializedName("strYoutube")
    val youtube: String,

    @field:SerializedName("strTwitter")
    val twitter: String,

    @field:SerializedName("strFacebook")
    val facebook: String,

    @field:SerializedName("strDescriptionEN")
    val description: String,

    @field:SerializedName("strStadiumThumb")
    val stadiumThumb: String,

    @field:SerializedName("strStadium")
    val stadium: String,

    @field:SerializedName("intStadiumCapacity")
    val stadiumCapacity: String,

    @field:SerializedName("strStadiumLocation")
    val stadiumLocation: String,

    @field:SerializedName("strStadiumDescription")
    val stadiumDescription: String,

    @field:SerializedName("strTeamJersey")
    val teamJersey: String,

    @field:SerializedName("strTeamBanner")
    val teamBanner: String
)
