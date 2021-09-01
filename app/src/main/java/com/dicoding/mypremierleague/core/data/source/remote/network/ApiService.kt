package com.dicoding.mypremierleague.core.data.source.remote.network

import com.dicoding.mypremierleague.BuildConfig
import com.dicoding.mypremierleague.core.data.source.remote.response.ListLeagueResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.ListMatchResultResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.ListStandingResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.ListTeamResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("lookuptable.php")
    suspend fun getListStanding(
        @Query("s") s: String,
        @Query("l") l: String = BuildConfig.LEAGUE,
    ): ListStandingResponse

    @GET("eventsround.php")
    suspend fun getListMatchResults(
        @Query("r") r: String,
        @Query("s") s: String,
        @Query("id") id: String = BuildConfig.LEAGUE
    ): ListMatchResultResponse

    @GET("lookupteam.php")
    suspend fun getDetailTeam(
        @Query("id") id: String,
    ): ListTeamResponse

    @GET("lookupleague.php")
    suspend fun getDetailLeague(
        @Query("id") id: String = BuildConfig.LEAGUE
    ): ListLeagueResponse

}