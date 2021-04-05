package io.github.fuadreza.basecleanarchitecture.presentation

import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import io.github.fuadreza.basecleanarchitecture.R
import io.github.fuadreza.basecleanarchitecture.abstraction.BaseActivity
import io.github.fuadreza.basecleanarchitecture.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override fun getViewModelClass(): Class<MainActivityViewModel> = MainActivityViewModel::class.java

    override fun getLayoutResourceId(): Int = R.layout.activity_main

    override fun initViews() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

    }
}