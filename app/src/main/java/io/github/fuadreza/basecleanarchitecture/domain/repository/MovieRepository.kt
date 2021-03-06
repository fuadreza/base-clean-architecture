package io.github.fuadreza.basecleanarchitecture.domain.repository

import io.github.fuadreza.core_android.data.vo.Results
import io.github.fuadreza.basecleanarchitecture.domain.entity.NowPlaying

interface MovieRepository {
    suspend fun getMovieNowPlaying(): Results<List<NowPlaying>>
}