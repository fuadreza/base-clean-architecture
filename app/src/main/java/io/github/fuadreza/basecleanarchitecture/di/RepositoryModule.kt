package io.github.fuadreza.basecleanarchitecture.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.github.fuadreza.basecleanarchitecture.data.repository.MovieRepositoryImpl
import io.github.fuadreza.basecleanarchitecture.domain.repository.MovieRepository

@InstallIn(ApplicationComponent::class)
@Module
interface RepositoryModule {
    @Binds
    fun bindMovieRepository(repository: MovieRepositoryImpl): MovieRepository
}