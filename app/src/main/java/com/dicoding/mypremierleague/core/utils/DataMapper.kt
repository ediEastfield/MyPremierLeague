package com.dicoding.mypremierleague.core.utils

import com.dicoding.mypremierleague.core.data.source.local.entity.MatchResultEntity
import com.dicoding.mypremierleague.core.data.source.local.entity.StandingEntity
import com.dicoding.mypremierleague.core.data.source.remote.response.MatchResultResponse
import com.dicoding.mypremierleague.core.data.source.remote.response.StandingResponse
import com.dicoding.mypremierleague.core.domain.model.MatchResult
import com.dicoding.mypremierleague.core.domain.model.Standing

object DataMapper {

    fun mapStandingEntitiesToDomain(input: List<StandingEntity>): List<Standing> =
        input.map {
            Standing(
                standingId = it.standingId,
                leagueId = it.leagueId,
                rank = it.rank,
                teamId = it.teamId,
                badgeTeam = it.badgeTeam,
                team = it.team,
                played = it.played,
                win = it.win,
                draw = it.draw,
                lost = it.lost,
                goalsFor = it.goalsFor,
                goalsAgainst = it.goalsAgainst,
                goalDifference = it.goalDifference,
                points = it.points
            )
        }

    fun mapMatchResultEntitiesToDomain(input: List<MatchResultEntity>): List<MatchResult> =
        input.map {
            MatchResult(
                eventId = it.eventId,
                event = it.event,
                leagueId = it.leagueId,
                league = it.league,
                season = it.season,
                description = it.description,
                homeTeam = it.homeTeam,
                awayTeam = it.awayTeam,
                homeScore = it.homeScore,
                round = it.round,
                awayScore = it.awayScore,
                dateEvent = it.dateEvent,
                homeTeamId = it.homeTeamId,
                awayTeamId = it.awayTeamId,
                venue = it.venue,
                thumb = it.thumb,
                status = it.status,
                video = it.video
            )
        }

    fun mapStandingResponsesToEntities(input: List<StandingResponse>): List<StandingEntity> {
        val standingLeagueList = ArrayList<StandingEntity>()
        input.map {
            val standingLeague = StandingEntity(
                standingId = it.standingId,
                leagueId = it.leagueId,
                rank = it.rank,
                teamId = it.teamId,
                badgeTeam = it.badgeTeam,
                team = it.team,
                played = it.played,
                win = it.win,
                draw = it.draw,
                lost = it.lost,
                goalsFor = it.goalsFor,
                goalsAgainst = it.goalsAgainst,
                goalDifference = it.goalDifference,
                points = it.points
            )
            standingLeagueList.add(standingLeague)
        }
        return standingLeagueList
    }

    fun mapEventResponsesToEntities(input: List<MatchResultResponse>): List<MatchResultEntity> {
        val matchResultList = ArrayList<MatchResultEntity>()
        input.map {
            val matchResult = MatchResultEntity(
                eventId = it.eventId,
                event = it.event,
                leagueId = it.leagueId,
                league = it.league,
                season = it.season,
                description = it.description,
                homeTeam = it.homeTeam,
                awayTeam = it.awayTeam,
                homeScore = it.homeScore,
                round = it.round,
                awayScore = it.awayScore,
                dateEvent = it.dateEvent,
                homeTeamId = it.homeTeamId,
                awayTeamId = it.awayTeamId,
                venue = it.venue,
                thumb = it.thumb,
                status = it.status,
                video = it.video
            )
            matchResultList.add(matchResult)
        }
        return matchResultList
    }

}