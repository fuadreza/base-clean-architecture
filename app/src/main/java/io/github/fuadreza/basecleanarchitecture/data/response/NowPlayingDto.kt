package io.github.fuadreza.basecleanarchitecture.data.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class NowPlayingDto(
    @field:Json(name = "results")
    val results: List<Result>?
) {
    @Entity(tableName = "now_playing")
    data class Result(
        @PrimaryKey
        @field:Json(name = "id")
        val id: Int?,
        @field:Json(name = "overview")
        val overview: String?,
        @field:Json(name = "poster_path")
        val posterPath: String?,
        @field:Json(name = "title")
        val title: String?
    )
}