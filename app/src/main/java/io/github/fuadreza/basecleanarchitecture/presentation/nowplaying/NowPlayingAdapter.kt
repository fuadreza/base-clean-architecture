package io.github.fuadreza.basecleanarchitecture.presentation.nowplaying

import com.bumptech.glide.Glide
import io.github.fuadreza.basecleanarchitecture.R
import io.github.fuadreza.basecleanarchitecture.abstraction.BaseRecyclerViewAdapter
import io.github.fuadreza.basecleanarchitecture.databinding.ListItemNowPlayingBinding
import io.github.fuadreza.basecleanarchitecture.domain.entity.NowPlaying

class NowPlayingAdapter : BaseRecyclerViewAdapter<NowPlaying, ListItemNowPlayingBinding>() {

    override fun getLayout(): Int = R.layout.list_item_now_playing

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ListItemNowPlayingBinding>,
        position: Int
    ) {
        holder.binding.data = items[position]
        val url = "https://image.tmdb.org/t/p/w500${items[position].posterPath}"
        Glide.with(holder.itemView)
            .load(url)
            .into(holder.binding.ivBackdrop)
    }
}