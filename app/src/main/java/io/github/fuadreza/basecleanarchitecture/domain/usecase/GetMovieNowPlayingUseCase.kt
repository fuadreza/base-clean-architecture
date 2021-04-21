package io.github.fuadreza.basecleanarchitecture.domain.usecase

import io.github.fuadreza.core_android.abstraction.UseCase
import io.github.fuadreza.core_android.data.vo.Results
import io.github.fuadreza.basecleanarchitecture.domain.entity.NowPlaying
import io.github.fuadreza.basecleanarchitecture.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieNowPlayingUseCase @Inject constructor(private val movieRepository: MovieRepository) :
    UseCase<UseCase.None, Results<List<NowPlaying>>>() {
    override suspend fun invoke(params: None): Results<List<NowPlaying>> {
        return movieRepository.getMovieNowPlaying()
    }
}