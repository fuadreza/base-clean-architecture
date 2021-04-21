package io.github.fuadreza.basecleanarchitecture.presentation.nowplaying

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.fuadreza.core_android.data.vo.Results
import io.github.fuadreza.basecleanarchitecture.domain.entity.NowPlaying
import io.github.fuadreza.basecleanarchitecture.domain.usecase.GetMovieNowPlayingUseCase
import io.github.fuadreza.core_android.abstraction.UseCase
import kotlinx.coroutines.launch

class NowPlayingViewModel @ViewModelInject constructor(
    private val getMovieNowPlayingUseCase: GetMovieNowPlayingUseCase
): ViewModel() {

    private val _nowPlaying = MutableLiveData<Results<List<NowPlaying>>>()
    val nowPlaying: LiveData<Results<List<NowPlaying>>>
        get() = _nowPlaying

    fun getNowPlaying() {
        _nowPlaying.value = Results.Loading
        viewModelScope.launch {
            _nowPlaying.value = getMovieNowPlayingUseCase(UseCase.None)
        }
    }
}