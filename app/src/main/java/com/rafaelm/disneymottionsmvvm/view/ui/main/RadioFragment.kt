package com.rafaelm.disneymottionsmvvm.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rafaelm.disneymottionsmvvm.R
import com.rafaelm.disneymottionsmvvm.base.DatabindingFragment
import com.rafaelm.disneymottionsmvvm.databinding.FragmentRadioBinding
import com.rafaelm.disneymottionsmvvm.view.adapter.PosterCircleAdapter
import org.koin.android.viewmodel.ext.android.getSharedViewModel


class RadioFragment : DatabindingFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentRadioBinding>(inflater, R.layout.fragment_radio, container).apply {
            viewModel = getSharedViewModel<MainViewModel>().apply { fetchDisneyPosterList() }
            lifecycleOwner = viewLifecycleOwner
            adapter = PosterCircleAdapter()
        }.root
    }
}