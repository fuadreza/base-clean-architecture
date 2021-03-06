package io.github.fuadreza.basecleanarchitecture.data.source.remote

import io.github.fuadreza.basecleanarchitecture.data.response.NowPlayingDto
import io.github.fuadreza.basecleanarchitecture.data.service.MovieService
import io.github.fuadreza.core_android.data.source.RemoteDataSource
import io.github.fuadreza.core_android.data.vo.Results
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieRemoteDataSource @Inject constructor(private val movieService: MovieService) :
    RemoteDataSource() {

    suspend fun getMovieNowPlaying(dispatcherProvider: CoroutineDispatcher): Results<NowPlayingDto> {
        return safeApiCall(dispatcherProvider) { movieService.getMovieNowPlaying() }
    }
}