package com.dicoding.mypremierleague.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "teamId")
    var teamId: String,

    @ColumnInfo(name = "teamBadge")
    var teamBadge: String,

    @ColumnInfo(name = "team")
    var team: String,

    @ColumnInfo(name = "keywords")
    var keywords: String,

    @ColumnInfo(name = "formedYear")
    var formedYear: String,

    @ColumnInfo(name = "instagram")
    var instagram: String,

    @ColumnInfo(name = "website")
    var website: String,

    @ColumnInfo(name = "youtube")
    var youtube: String,

    @ColumnInfo(name = "twitter")
    var twitter: String,

    @ColumnInfo(name = "facebook")
    var facebook: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "stadiumThumb")
    var stadiumThumb: String,

    @ColumnInfo(name = "stadium")
    var stadium: String,

    @ColumnInfo(name = "stadiumCapacity")
    var stadiumCapacity: String,

    @ColumnInfo(name = "stadiumLocation")
    var stadiumLocation: String,

    @ColumnInfo(name = "stadiumDescription")
    var stadiumDescription: String,

    @ColumnInfo(name = "teamJersey")
    var teamJersey: String,

    @ColumnInfo(name = "teamBanner")
    var teamBanner: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
