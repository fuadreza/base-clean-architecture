package io.github.fuadreza.basecleanarchitecture.abstraction

import androidx.annotation.LayoutRes

interface IBaseView {
    @LayoutRes
    fun getLayoutResourceId(): Int
    fun initViews(){}
    fun initObservers(){}
}