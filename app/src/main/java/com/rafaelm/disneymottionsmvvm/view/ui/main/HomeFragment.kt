package com.rafaelm.disneymottionsmvvm.view.ui.main

import android.graphics.Color
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.rafaelm.disneymottionsmvvm.R
import com.rafaelm.disneymottionsmvvm.base.DatabindingFragment
import com.rafaelm.disneymottionsmvvm.databinding.FragmentHomeBinding
import com.rafaelm.disneymottionsmvvm.extensions.gone
import com.rafaelm.disneymottionsmvvm.extensions.visible
import com.rafaelm.disneymottionsmvvm.view.adapter.PosterAdapter
import org.koin.android.viewmodel.ext.android.getSharedViewModel

class HomeFragment : DatabindingFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentHomeBinding> (inflater, R.layout.fragment_home, container).apply {
            viewModelFrag = getSharedViewModel<MainViewModel>().apply { fetchDisneyPosterList() }
            lifecycleOwner = viewLifecycleOwner
            adapter = PosterAdapter()
            this@HomeFragment.binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            TransitionManager.beginDelayedTransition(
                binding.container,
                getTransform(it, binding.card)
            )
            binding.card.visible()
            it.gone(true)
        }

        binding.card.setOnClickListener {
            TransitionManager.beginDelayedTransition(
                binding.container,
                getTransform(it, binding.fab)
            )
            binding.fab.visible()
            it.gone(true)
        }
    }

    private fun getTransform(mStartView: View, mEndView: View): MaterialContainerTransform {
        return MaterialContainerTransform().apply {
            startView = mStartView
            endView = mEndView
            addTarget(mEndView)
            pathMotion = MaterialArcMotion()
            duration = 550
            scrimColor = Color.TRANSPARENT
        }
    }
}