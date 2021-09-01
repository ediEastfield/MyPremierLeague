package com.dicoding.mypremierleague.core.data.source.remote

import android.util.Log
import com.dicoding.mypremierleague.core.data.source.remote.network.ApiResponse
import com.dicoding.mypremierleague.core.data.source.remote.network.ApiService
import com.dicoding.mypremierleague.core.data.source.remote.response.LeagueResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.MatchResultResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.StandingResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getStandingLeague(s: String): Flow<ApiResponse<List<StandingResponse>>> {
        return  flow {
            try {
                val response = apiService.getListStanding(s)
                val dataArray = response.table
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.table))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMatchResults(r: String, s: String): Flow<ApiResponse<List<MatchResultResponse>>> {
        return  flow {
            try {
                val response = apiService.getListMatchResults(r, s)
                val dataArray = response.events
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.events))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailTeam(teamId: String): Flow<ApiResponse<List<TeamResponse>>> {
        return flow {
            try {
                val response = apiService.getDetailTeam(teamId)
                val dataArray = response.teams
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.teams))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getDetailLeague(): Flow<ApiResponse<List<LeagueResponse>>> {
        return flow {
            try {
                val response = apiService.getDetailLeague()
                val dataArray = response.leagues
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.leagues))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}