package com.rafaelm.disneymottionsmvvm.view.ui.main

import android.os.Bundle
import com.rafaelm.disneymottionsmvvm.R
import com.rafaelm.disneymottionsmvvm.base.DatabindingActivity
import com.rafaelm.disneymottionsmvvm.databinding.ActivityMainBinding
import com.rafaelm.disneymottionsmvvm.extensions.applyExitMaterialTransform
import org.koin.android.viewmodel.ext.android.getViewModel

class MainActivity : DatabindingActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        applyExitMaterialTransform()
        super.onCreate(savedInstanceState)
        binding.apply {
            pagerAdapter = MainPagerAdapter(this@MainActivity)
            lifecycleOwner = this@MainActivity
            vm = getViewModel()
        }
    }
}
