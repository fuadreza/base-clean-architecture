package io.github.fuadreza.basecleanarchitecture.domain.entity

data class NowPlaying(
    val id: Int,
    val overview: String,
    val posterPath: String,
    val title: String
)