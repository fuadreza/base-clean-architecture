package io.github.fuadreza.basecleanarchitecture.data.repository

import io.github.fuadreza.basecleanarchitecture.data.dispatcher.DispatcherProvider
import io.github.fuadreza.basecleanarchitecture.data.mapper.MovieMapper
import io.github.fuadreza.basecleanarchitecture.data.source.local.dao.NowPlayingDao
import io.github.fuadreza.basecleanarchitecture.data.source.remote.MovieRemoteDataSource
import io.github.fuadreza.basecleanarchitecture.data.vo.Results
import io.github.fuadreza.basecleanarchitecture.domain.entity.NowPlaying
import io.github.fuadreza.basecleanarchitecture.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: NowPlayingDao,
    private val movieMapper: MovieMapper
) : MovieRepository {
    override suspend fun getMovieNowPlaying(): Results<List<NowPlaying>> {
        val apiResult = remoteDataSource.getMovieNowPlaying(dispatcher.io)
        return when (apiResult) {
            is Results.Success -> Results.Success(movieMapper.map(apiResult.data))
            is Results.Error -> Results.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
            else -> Results.Error()
        }
    }
}