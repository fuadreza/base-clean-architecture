package io.github.fuadreza.basecleanarchitecture.presentation.nowplaying

import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.github.fuadreza.basecleanarchitecture.R
import io.github.fuadreza.basecleanarchitecture.abstraction.BaseFragment
import io.github.fuadreza.basecleanarchitecture.data.vo.Results
import io.github.fuadreza.basecleanarchitecture.databinding.FragmentNowPlayingBinding
import io.github.fuadreza.basecleanarchitecture.domain.entity.NowPlaying
import timber.log.Timber

@AndroidEntryPoint
class NowPlayingFragment: BaseFragment<FragmentNowPlayingBinding, NowPlayingViewModel>() {

    private lateinit var nowPlayingAdapter: NowPlayingAdapter

    override fun getViewModelClass(): Class<NowPlayingViewModel> = NowPlayingViewModel::class.java

    override fun getLayoutResourceId(): Int = R.layout.fragment_now_playing

    override fun initViews() {
        vm.getNowPlaying()
        Timber.tag("FETCH").d("INITIAL")
    }

    override fun initObservers() {
        vm.nowPlaying.observe(this){
            when (it) {
                is Results.Loading -> {
                    Timber.tag("FETCH").d("LOADING")
                }
                is Results.Success -> {
//                    adapter.refreshNowPlaying(it.data)
                    setupList(it.data)
                }
                is Results.Empty -> {

                }
                is Results.Error -> {

                }
            }
        }
    }

    private fun setupList(data: List<NowPlaying>) {
        nowPlayingAdapter = NowPlayingAdapter()

        binding.rvNowPlaying.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(context)
            adapter = nowPlayingAdapter
        }
        nowPlayingAdapter.addItems(data)
    }
}
