package io.github.fuadreza.basecleanarchitecture.presentation.nowplaying

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.github.fuadreza.basecleanarchitecture.R
import io.github.fuadreza.core_android.abstraction.BaseFragment
import io.github.fuadreza.core_android.data.vo.Results
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
                    showLoading(true)
                }
                is Results.Success -> {
                    showLoading(false)
                    setupList(it.data)
                }
                is Results.Empty -> {
                    showLoading(false)
                }
                is Results.Error -> {
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(state: Boolean) {
        if(state){
            binding.shimmerViewContainer.startShimmer()
        }else {
            binding.shimmerViewContainer.stopShimmer()
            binding.shimmerViewContainer.visibility = View.GONE
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
