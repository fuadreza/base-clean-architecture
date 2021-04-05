package io.github.fuadreza.basecleanarchitecture.data.service

import io.github.fuadreza.basecleanarchitecture.BuildConfig
import io.github.fuadreza.basecleanarchitecture.data.response.NowPlayingDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/now_playing")
    suspend fun getMovieNowPlaying(@Query("api_key") apiKey: String = BuildConfig.API_KEY): NowPlayingDto
}