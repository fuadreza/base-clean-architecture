package io.github.fuadreza.basecleanarchitecture.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.github.fuadreza.basecleanarchitecture.data.dispatcher.CoroutineDispatcherProvider
import io.github.fuadreza.basecleanarchitecture.data.dispatcher.DispatcherProvider

@InstallIn(ApplicationComponent::class)
@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider): DispatcherProvider
}