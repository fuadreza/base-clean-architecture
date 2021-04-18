package io.github.fuadreza.basecleanarchitecture.data.mapper

import io.github.fuadreza.core_android.abstraction.Mapper
import io.github.fuadreza.basecleanarchitecture.data.response.NowPlayingDto
import io.github.fuadreza.basecleanarchitecture.domain.entity.NowPlaying
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<NowPlayingDto, List<NowPlaying>>() {
    override fun map(input: NowPlayingDto): List<NowPlaying> {
        return input.results?.map {
            NowPlaying(
                it.id ?: 0,
                it.overview ?: "",
                it.posterPath ?: "",
                it.title ?: ""
            )
        } ?: emptyList()
    }
}